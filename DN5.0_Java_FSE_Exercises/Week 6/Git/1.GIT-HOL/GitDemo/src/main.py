#!/usr/bin/env python3
"""
GitDemo Main Application
A simple Python application to demonstrate Git version control.
"""

def main():
    """
    Main function that displays welcome messages and demonstrates Git concepts.
    """
    print("=" * 60)
    print("         WELCOME TO GIT DEMO PROJECT")
    print("=" * 60)
    print("\nThis is a simple Python application.")
    print("It demonstrates Git version control with VS Code.")
    print("\n" + "-" * 60)
    print("GIT FEATURES DEMONSTRATED:")
    print("-" * 60)
    print("  ✓ Git initialization and configuration")
    print("  ✓ File tracking and staging")
    print("  ✓ Commit management")
    print("  ✓ Branching and merging")
    print("  ✓ Remote repository integration")
    print("  ✓ VS Code Git integration")
    print("=" * 60)
    print("Project Status: Active")
    print("Version: 1.0.0")
    print("=" * 60)

def calculate_sum(a, b):
    """
    Calculate the sum of two numbers.
    
    Args:
        a (int/float): First number
        b (int/float): Second number
    
    Returns:
        int/float: Sum of a and b
    """
    return a + b

def calculate_product(a, b):
    """
    Calculate the product of two numbers.
    
    Args:
        a (int/float): First number
        b (int/float): Second number
    
    Returns:
        int/float: Product of a and b
    """
    return a * b

def get_project_info():
    """
    Get project information.
    
    Returns:
        dict: Project information
    """
    return {
        'name': 'GitDemo',
        'version': '1.0.0',
        'author': 'Sidhi Gautam',
        'email': 'sidhigautam6@gmail.com',
        'created': '2026-07-25',
        'status': 'Active',
        'description': 'Git Hands-On Lab Project'
    }

def display_git_commands():
    """
    Display commonly used Git commands.
    """
    print("\n" + "=" * 60)
    print("COMMONLY USED GIT COMMANDS")
    print("=" * 60)
    print("\n  git init          - Initialize a new Git repository")
    print("  git status        - Check the status of your repository")
    print("  git add <file>    - Stage a file for commit")
    print("  git add .         - Stage all changes")
    print("  git commit -m     - Commit staged changes with a message")
    print("  git log           - View commit history")
    print("  git log --oneline - View compact commit history")
    print("  git branch        - List all branches")
    print("  git checkout -b   - Create and switch to a new branch")
    print("  git merge         - Merge a branch into current branch")
    print("  git remote add    - Add a remote repository")
    print("  git push          - Push changes to remote")
    print("  git pull          - Pull changes from remote")
    print("  git clone         - Clone a remote repository")
    print("=" * 60)

def display_project_structure():
    """
    Display the project directory structure.
    """
    print("\n" + "=" * 60)
    print("PROJECT STRUCTURE")
    print("=" * 60)
    print("""
    GitDemo/
    ├── .git/                    # Git repository (hidden)
    ├── .gitignore              # Ignored files
    ├── README.md               # Project documentation
    ├── welcome.txt             # Welcome message
    ├── CHANGELOG.md            # Change log
    ├── LICENSE                 # MIT License
    ├── requirements.txt        # Python dependencies
    ├── src/                    # Source code
    │   └── main.py             # Main application
    └── docs/                   # Documentation
        └── setup.md            # Setup guide
    """)

def interactive_demo():
    """
    Interactive demonstration of some features.
    """
    print("\n" + "=" * 60)
    print("INTERACTIVE DEMO")
    print("=" * 60)
    
    # Get user input
    try:
        num1 = float(input("\nEnter first number: "))
        num2 = float(input("Enter second number: "))
        
        # Calculate and display results
        print("\n" + "-" * 60)
        print("CALCULATION RESULTS:")
        print("-" * 60)
        print(f"  {num1} + {num2} = {calculate_sum(num1, num2)}")
        print(f"  {num1} × {num2} = {calculate_product(num1, num2)}")
        print("=" * 60)
        
    except ValueError:
        print("\n❌ Error: Please enter valid numbers!")
        print("=" * 60)

def main_menu():
    """
    Display main menu for the application.
    """
    print("\n" + "=" * 60)
    print("MAIN MENU")
    print("=" * 60)
    print("  1. Show project information")
    print("  2. Show Git commands")
    print("  3. Show project structure")
    print("  4. Interactive demo")
    print("  5. Exit")
    print("=" * 60)

def run_menu():
    """
    Run the interactive menu.
    """
    while True:
        main_menu()
        choice = input("\nEnter your choice (1-5): ").strip()
        
        if choice == '1':
            info = get_project_info()
            print("\n" + "=" * 60)
            print("PROJECT INFORMATION")
            print("=" * 60)
            for key, value in info.items():
                print(f"  {key}: {value}")
            print("=" * 60)
            
        elif choice == '2':
            display_git_commands()
            
        elif choice == '3':
            display_project_structure()
            
        elif choice == '4':
            interactive_demo()
            
        elif choice == '5':
            print("\n" + "=" * 60)
            print("Thank you for using GitDemo!")
            print("Keep learning Git! 🚀")
            print("=" * 60)
            break
            
        else:
            print("\n❌ Invalid choice! Please enter a number between 1 and 5.")
        
        input("\nPress Enter to continue...")
        print("\n" * 2)

if __name__ == "__main__":
    # Display welcome banner
    main()
    
    # Show project info
    print("\n📁 Project Details:")
    info = get_project_info()
    for key, value in info.items():
        print(f"  • {key}: {value}")
    
    # Run interactive menu
    run_menu()