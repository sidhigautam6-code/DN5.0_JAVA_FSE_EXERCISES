#!/usr/bin/env python3
"""
Branching and Merging Demo
This script demonstrates Git branching concepts.
"""

import os
import subprocess

def print_header(text):
    """Print a formatted header."""
    print("\n" + "=" * 60)
    print(f"  {text}")
    print("=" * 60)

def run_git_command(command):
    """Run a git command and return output."""
    try:
        result = subprocess.run(
            command,
            capture_output=True,
            text=True,
            shell=True,
            check=True
        )
        return result.stdout
    except subprocess.CalledProcessError as e:
        return f"Error: {e.stderr}"

def demo_branching_commands():
    """Display all Git branching commands."""
    print_header("GIT BRANCHING COMMANDS")
    print("""
    1. git branch                  - List all branches
    2. git branch <name>           - Create a new branch
    3. git checkout <name>         - Switch to a branch
    4. git checkout -b <name>      - Create and switch to branch
    5. git merge <branch>          - Merge branch into current
    6. git branch -d <branch>      - Delete a branch
    7. git branch -D <branch>      - Force delete a branch
    8. git diff <branch1> <branch2> - Show differences between branches
    9. git log --graph             - View branch graph
    """)

def demo_merge_workflow():
    """Display the merge workflow."""
    print_header("MERGE WORKFLOW")
    print("""
    1. Create a branch:     git checkout -b feature-branch
    2. Make changes:        edit files
    3. Commit changes:      git add . && git commit -m "message"
    4. Switch to master:    git checkout master
    5. Merge:               git merge feature-branch
    6. Delete branch:       git branch -d feature-branch
    """)

def check_branch_status():
    """Check and display current branch status."""
    print_header("CURRENT BRANCH STATUS")
    
    # Get current branch
    branch = run_git_command("git branch --show-current")
    print(f"Current Branch: {branch}")
    
    # List all branches
    branches = run_git_command("git branch")
    print("\nAll Branches:")
    print(branches)
    
    # Get commit history
    history = run_git_command("git log --oneline --graph --decorate")
    print("\nCommit History:")
    print(history)

def main():
    """Main function."""
    print_header("GIT BRANCHING AND MERGING DEMO")
    print("This script helps you learn Git branching concepts.\n")
    
    while True:
        print("\n" + "-" * 60)
        print("MAIN MENU")
        print("-" * 60)
        print("1. Show branching commands")
        print("2. Show merge workflow")
        print("3. Check current branch status")
        print("4. Create and switch to a new branch")
        print("5. Exit")
        print("-" * 60)
        
        choice = input("\nEnter your choice (1-5): ").strip()
        
        if choice == '1':
            demo_branching_commands()
            
        elif choice == '2':
            demo_merge_workflow()
            
        elif choice == '3':
            check_branch_status()
            
        elif choice == '4':
            branch_name = input("Enter new branch name: ").strip()
            if branch_name:
                print(f"Creating and switching to '{branch_name}'...")
                result = run_git_command(f"git checkout -b {branch_name}")
                print(result)
            else:
                print("❌ Branch name cannot be empty!")
                
        elif choice == '5':
            print("\n✅ Thank you for using the Git Branching Demo!")
            print("📚 Keep practicing Git branching!")
            break
            
        else:
            print("\n❌ Invalid choice! Please enter a number between 1 and 5.")
        
        input("\nPress Enter to continue...")

if __name__ == "__main__":
    main()