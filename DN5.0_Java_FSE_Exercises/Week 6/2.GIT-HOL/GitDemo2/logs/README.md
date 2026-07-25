# Logs Directory

This directory contains application log files.

## Important Note

⚠️ **These log files are ignored by Git**

The `.gitignore` file is configured to exclude:
- All `.log` files
- The entire `logs/` folder

## Why Ignore Log Files?

1. **Large Size**: Log files can grow very large
2. **Sensitive Information**: Logs may contain passwords or user data
3. **Temporary Data**: Logs are regenerated on each run
4. **No Need in Repository**: Logs are not needed for code versioning

## Log Files Created

- `app.log` - Application logs
- `error.log` - Error logs

## How to Check

Run `git status` to verify these files are ignored.