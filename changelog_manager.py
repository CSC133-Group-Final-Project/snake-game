from git import Repo
import re
from datetime import datetime
import sys
import argparse

# Function to determine the current version based on the tag
def get_current_version(repo):
    if len(repo.tags) == 0:
        return "v0.1.0"
    else:
        tags = sorted(repo.tags, key=lambda t: t.commit.committed_datetime)
        return tags[-1].name

# Function to increment the version
def increment_version(version):
    version = version[1:]  # Remove the leading 'v'
    major, minor, patch = map(int, version.split('.'))
    return f"v{major}.{minor + 1}.{patch}"

# Function to create a new tag
def create_tag(repo, tag_name):
    repo.create_tag(tag_name)

# Function to determine the emoji based on commit message content
def determine_emoji(message):
    lower_case_message = message.lower()
    if "fix" in lower_case_message:
        return "🐛"
    elif "feature" in lower_case_message or "enhance" in lower_case_message:
        return "✨"
    elif "refactor" in lower_case_message:
        return "🔨"
    elif "docs" in lower_case_message or "readme" in lower_case_message or "changelog" in lower_case_message or "documentation" in lower_case_message:
        return "📚"
    elif "performance" in lower_case_message or "speed" in lower_case_message or "optimize" in lower_case_message:
        return "🚀"
    elif "test" in lower_case_message:
        return "🧪"
    elif "style" in lower_case_message or "lint" in lower_case_message or "ui" in lower_case_message or "aesthetic" in lower_case_message or "format" in lower_case_message:
        return "🎨"
    elif "security" in lower_case_message:
        return "🔒"
    elif "breaking" in lower_case_message or "deprecate" in lower_case_message:
        return "💥"
    elif "ci" in lower_case_message or "pipeline" in lower_case_message:
        return "🚦"
    elif "config" in lower_case_message:
        return "🔧"
    elif "dependency" in lower_case_message:
        return "📦"
    elif "release" in lower_case_message:
        return "🏷️"
    elif "license" in lower_case_message:
        return "📝"
    elif "chore" in lower_case_message:
        return "🧹"
    elif "wip" in lower_case_message:
        return "🚧"
    elif "revert" in lower_case_message:
        return "⏪"
    elif "merge" in lower_case_message:
        return "🔀"
    elif "add" in lower_case_message:
        return "➕"
    elif "remove" in lower_case_message:
        return "➖"
    elif "move" in lower_case_message:
        return "🚚"
    elif "rename" in lower_case_message:
        return "🔁"
    elif "update" in lower_case_message:
        return "🔃"
    elif "improve" in lower_case_message:
        return "👍"
    elif "clean" in lower_case_message:
        return "🧼"
    elif "comment" in lower_case_message:
        return "💬"
    elif "work" in lower_case_message:
        return "👷"
    elif "reorganize" in lower_case_message:
        return "🗄️"
    elif "implement" in lower_case_message:
        return "👨‍💻"
    else:
        return "📝"

# Function to format a single commit message
def format_commit_message(commit_hash, message):
    formatted_message = ""
    is_first_line = True
    processing_bullet_points = False

    for line in message.split('\n'):
        # Skip lines containing "Signed-off-by"
        if "signed-off-by" in line.lower():
            continue

        if re.match(r'^\s*-', line):  # Detects bullet points
            bullet_emoji = determine_emoji(line)  # Determine emoji for each bullet point
            line = re.sub(r'^\s*-\s*', '', line)  # Removes bullet point hyphen
            formatted_message += f"    - {bullet_emoji} {line}\n"
            formatted_message += "\n"  # Add a new line after each bullet point
            processing_bullet_points = True
        elif line.strip() == "":
            continue
        else:
            if is_first_line or not processing_bullet_points:
                emoji = determine_emoji(line)
                short_commit_hash = commit_hash[:7]
                # Use bold for headers
                formatted_message += f"**{emoji} {line}** ([`{short_commit_hash}`](https://github.com/Snake-Charmers/charming-snake/commit/{commit_hash}))\n"
                formatted_message += "\n"
                is_first_line = False
            processing_bullet_points = False

    return formatted_message

# Main function to generate the changelog
def generate_changelog(repo_path, since_tag, new_tag):
    repo = Repo(repo_path)

    # Ensure since_tag exists in the repo
    if since_tag not in [tag.name for tag in repo.tags]:
        raise ValueError(f"Tag {since_tag} not found in repository")

    # Get commits since the specified tag
    commits = list(repo.iter_commits(f"{since_tag}..HEAD"))

    new_changelog_content = f"## [{new_tag}] - {datetime.now().strftime('%Y-%m-%d')}\n\n"

    for commit in commits:
        formatted_message = format_commit_message(commit.hexsha, commit.message)
        new_changelog_content += formatted_message

    new_changelog_content += "\n---\n"

    with open("RELEASE_CHANGELOG.md", "w") as file:
        file.write(new_changelog_content)


def check_for_new_tag(repo_path):
    repo = Repo(repo_path)
    # if no tags exist, then a new tag is needed
    if not repo.tags:
        print("true")
        sys.exit(0)

    last_tag = repo.tags[-1] if repo.tags else None

    commits_since_last_tag = list(repo.iter_commits(f"{last_tag}..HEAD")) if last_tag else repo.iter_commits()

    if len(commits_since_last_tag) >= 5:
        print("true")
        sys.exit(0)  # Exit with 0 to indicate a new tag is needed
    else:
        print("false")
        sys.exit(1)  # Exit with 1 to indicate no new tag is needed

def is_initial_tag(repo_path):
    repo = Repo(repo_path)
    if repo.tags:
        return False
    else:
        return True
 
# Add new function to generate initial changelog
def generate_initial_changelog(repo_path, initial_version):
    repo = Repo(repo_path)
    commits = list(repo.iter_commits())
    changelog_content = f"## [{initial_version}] - {datetime.now().strftime('%Y-%m-%d')}\n\n"

    for commit in commits:
        formatted_message = format_commit_message(commit.hexsha, commit.message)
        changelog_content += formatted_message

    changelog_content += "\n---\n"
    with open("CHANGELOG.md", "w") as changelog:
        changelog.write(changelog_content)

# Function to update the running changelog
def update_running_changelog(repo_path, current_version):
    repo = Repo(repo_path)
    last_tag = repo.tags[-1] if repo.tags else None
    next_version = increment_version(current_version)

    # Prepare the running changelog content
    running_changelog_content = f"<!-- RUNNING CHANGELOG START -->\n## [{next_version}] - {datetime.now().strftime('%Y-%m-%d')}\n\n"

    commits = list(repo.iter_commits(f"{last_tag}..HEAD")) if last_tag else list(repo.iter_commits())

    for commit in commits:
        formatted_message = format_commit_message(commit.hexsha, commit.message)
        running_changelog_content += formatted_message

    running_changelog_content += "\n<!-- RUNNING CHANGELOG END -->\n"

    # Read the existing CHANGELOG.md content
    with open("CHANGELOG.md", "r") as file:
        changelog_content = file.read()

    # Check if running changelog section exists
    if "<!-- RUNNING CHANGELOG START -->" in changelog_content:
        # Replace the existing running changelog section
        new_changelog_content = re.sub(r'<!-- RUNNING CHANGELOG START -->.*<!-- RUNNING CHANGELOG END -->',
                                       running_changelog_content, changelog_content, flags=re.DOTALL)
    else:
        # Append the new running changelog at the top
        new_changelog_content = running_changelog_content + "\n" + changelog_content

    # Write the updated content back to CHANGELOG.md
    with open("CHANGELOG.md", "w") as file:
        file.write(new_changelog_content)


# Main function
def main():
    parser = argparse.ArgumentParser(description="Manage changelogs and version tags for a git repository.")
    parser.add_argument("action", choices=["generate", "check", "increment", "initial", "update-running", "current-version", "is-initial-tag"], help="The action to perform: 'generate' for changelog, 'check' for new tag, 'increment' for version, 'initial' for initial tag and changelog, 'update-running' for running changelog, 'current-version' for current version, or 'is-initial-tag' for initial tag check.")
    parser.add_argument("--repo-path", default=".", help="Path to the git repository.")
    parser.add_argument("--since-tag", help="The tag since which the changelog should be generated.")
    parser.add_argument("--new-tag", help="The new tag for which the changelog is generated.")
    args = parser.parse_args()

    if args.action == "initial":
        repo = Repo(args.repo_path)
        if repo.tags:
            print("Initial tag already exists.")
            sys.exit(1)
        else:
            initial_version = "v0.1.0"
            create_tag(repo, initial_version)
            generate_initial_changelog(args.repo_path, initial_version)
            print(initial_version)
    elif args.action == "generate":
        if not args.since_tag or not args.new_tag:
            parser.error("'generate' action requires --since-tag and --new-tag")
        generate_changelog(args.repo_path, args.since_tag, args.new_tag)
        print(f"Generated changelog for {args.since_tag}..{args.new_tag}")
    elif args.action == "check":
        check_for_new_tag(args.repo_path)
        print("Checked for new tag")
    elif args.action == "increment":
        repo = Repo(args.repo_path)
        current_version = get_current_version(repo)
        new_version = increment_version(current_version)
        print(new_version)
    elif args.action == "update-running":
        repo = Repo(args.repo_path)
        current_version = get_current_version(repo)
        update_running_changelog(args.repo_path, current_version)
        print("Updated running changelog")
    elif args.action == "current-version":
        repo = Repo(args.repo_path)
        current_version = get_current_version(repo)
        print(current_version)
    elif args.action == "is-initial-tag":
        is_initial = is_initial_tag(args.repo_path)
        print(is_initial)
    else:
        parser.error("Invalid action")

if __name__ == "__main__":
    main()

# Example usage:
# python changelog_manager.py generate --since-tag v0.1.0 --new-tag v0.2.0
# python changelog_manager.py check
# python changelog_manager.py increment
# python changelog_manager.py current-version
# python changelog_manager.py update-running --repo-path charming-snake
# python changelog_manager.py is-initial-tag --repo-path charming-snake
# python changelog_manager.py initial --repo-path charming-snake