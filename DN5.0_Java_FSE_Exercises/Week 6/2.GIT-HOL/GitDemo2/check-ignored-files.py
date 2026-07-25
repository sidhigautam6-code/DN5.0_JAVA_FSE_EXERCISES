#!/usr/bin/env python3
"""
Check which files are ignored by Git
"""

import os
import subprocess

def get_git_ignored_files():
    """
    Get list of ignored files using git status --ignored
    """
    try:
        result = subprocess.run(
            ['git', 'status', '--ignored', '--porcelain'],
            capture_output=True,
            text=True,
            cwd=os.getcwd()
        )
        
        ignored_files = []
        for line in result.stdout.split('\n'):
            if line.startswith('!!'):
                ignored_files.append(line[3:])
        
        return ignored_files
    except Exception as e:
        print(f"Error: {e}")
        return []

def check_file_status(filepath):
    """
    Check if a specific file is ignored or tracked
    """
    try:
        result = subprocess.run(
            ['git', 'check-ignore', filepath],
            capture_output=True,
            text=True,
            cwd=os.getcwd()
        )
        
        if result.returncode == 0:
            return "Ignored"
        else:
            return "Tracked"
    except Exception:
        return "Unknown"

def main():
    """
    Main function to check ignored files
    """
    print("=" * 60)
    print("GIT IGNORED FILES CHECK")
    print("=" * 60)
    
    # List of files to check
    files_to_check = [
        'app.log',
        'debug.log',
        'logs/app.log',
        'logs/error.log',
        'logs/',
        'src/main.py',
        'README.md',
        '.gitignore'
    ]
    
    print("\nChecking file status:")
    print("-" * 60)
    
    for file in files_to_check:
        status = check_file_status(file)
        print(f"  {file:<30} → {status}")
    
    print("-" * 60)
    
    # Get all ignored files from git status
    ignored = get_git_ignored_files()
    
    if ignored:
        print("\nAll ignored files in this repository:")
        print("-" * 60)
        for file in ignored:
            print(f"  • {file}")
    else:
        print("\n✅ No files are being ignored.")
    
    print("=" * 60)

if __name__ == "__main__":
    main()