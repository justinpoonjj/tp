# Unicornyingg - Project Portfolio Page

## Overview
ResuMake is a CLI-based resume content manager that helps students organize project and experience entries quickly.
It supports creating structured records (projects, experiences, CCAs), managing bullet points, and persisting data across sessions.

My main contributions focused on improving record/bullet editing workflows and strengthening reliability through better deletion and storage behavior.

## Summary of contributions

### Code contributed
- [RepoSense link for my code contributions](https://nus-cs2113-ay2526-s2.github.io/tp-dashboard/?search=unicornyingg&breakdown=true&sort=groupTitle%20dsc&sortWithin=title&since=2026-02-20T00%3A00%3A00&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&filteredFileName=)

### Enhancements implemented
1. Extended deletion workflows for records and bullets
   - Added support for deleting entire records and deleting specific bullets from records through the command flow.
   - Improved parser integration to support bullet deletion command formats.
   - Added validation and error handling for invalid delete indices.

2. Improved save/load storage behavior
   - Implemented structured persistence for records (title, role, tech, dates).
   - Added bullet-point persistence so bullet edits survive app restarts.
   - Hardened load parsing to handle malformed lines safely instead of crashing.

3. Unified exception handling model
   - Added and integrated a single application-specific checked exception (`ResumakeException`) following the team’s command-handling style.
   - Updated command and storage execution flows to propagate meaningful user-facing errors.

4. Added targeted tests for implemented features
   - Added/updated parser and delete command tests, including bullet deletion scenarios and invalid-index behavior.
   - Ensured changes pass the project’s Gradle test and check pipeline.

### Contributions to the User Guide
- Added/updated command behavior details for delete-related workflows (record deletion and bullet deletion).
- Clarified persistence behavior so users understand records are loaded on startup and saved to file.

### Contributions to the Developer Guide
- Added value proposition and user stories aligned with implemented features (including bullet deletion and startup loading).
- Documented exception-handling and storage-related design decisions in code and supporting docs.


