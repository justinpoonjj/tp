# ResuMake User Guide

ResuMake is a command-line resume content manager that helps you store, edit, and organize resume records quickly.

You can manage:
- Projects
- Experiences
- CCAs
- Bullet points under each record

ResuMake runs in the terminal and saves your data locally in `records.txt` so records persist across sessions.

---

## Quick Start

1. Ensure you have Java 17 installed.
2. Place the jar file in an empty folder
3. Navigate to that file in the terminal and run `java -jar ResuMake.jar`

---

## Quick Navigation

- [list](#viewing-records--list)
- [project](#adding-a-project--project)
- [experience](#adding-an-experience--experience)
- [cca](#adding-a-cca--cca)
- [show](#showing-one-record--show)
- [find](#finding-records-by-keyword--find)
- [findbullet](#finding-bullets-by-keyword--findbullet)
- [addbullet](#adding-a-bullet--addbullet)
- [edit](#editing-a-record--edit)
- [editbullet](#editing-a-bullet--editbullet)
- [edituser](#editing-a-user--edituser)
- [movebullet](#moving-a-bullet--movebullet)
- [delete](#deleting-a-record--delete)
- [deletebullet](#deleting-a-bullet--deletebullet)
- [sort](#sorting-records-by-title--sort)
- [generate](#generating-resume--generate)
- [bye](#exiting-the-program--bye)

---

## Features

> Note:
> - Words in `UPPER_CASE` are inputs provided by you.
> - Command keywords are case-insensitive (e.g., `LIST`, `list`, `LiSt` all work).
> - Record and bullet indices are 1-based.
> - Date format is `YYYY-MM`.
> - For `project`, `experience`, and `cca`, flags must appear in this order: `/role`, `/tech`, `/from`, `/to`.
> - After each valid command, ResuMake auto-saves and prints `Records saved to file.`

---

### Viewing records : `list`
Lists all records, or filters by type.
 
Format:
`list [TYPE]`
 
- `TYPE` is optional. Valid values: `E` (Experience), `C` (CCA), `P` (Project).
- Leave blank to list all records.
 
Example:
```text
list C
```
 
Expected output:
```text
Here is a list of C records.
1. [C] Chess Club
2. [C] Dance Club
--------------------
```
 
---

### Adding a project : `project`

Adds a new project record.

Format:
`project TITLE /role ROLE /tech TECH /from YYYY-MM /to YYYY-MM`

Example:
```text
project Capo CLI /role Developer /tech Java /from 2026-01 /to 2026-03
```

Expected output:
```text
--------------------
[P] Capo CLI added
--------------------
```

---

### Adding an experience : `experience`

Adds a new experience record.

Format:
`experience TITLE /role ROLE /tech TECH /from YYYY-MM /to YYYY-MM`

Example:
```text
experience Google /role SWE Intern /tech JavaScript /from 2025-12 /to 2026-02
```

Expected output:
```text
--------------------
[E] Google added
--------------------
```

---

### Adding a CCA : `cca`

Adds a new CCA record.

Format:
`cca TITLE /role ROLE /tech TECH /from YYYY-MM /to YYYY-MM`

Example:
```text
cca NUS Hackers /role Core Member /tech Python /from 2025-01 /to 2026-01
```

Expected output:
```text
--------------------
[C] NUS Hackers added
--------------------
```

---
### Adding a bullet : `addbullet`

Adds a bullet to a record.

Format:
`addbullet RECORD_INDEX / BULLET_TEXT`

Example:
```text
addbullet 1 / Implemented persistent storage with file IO
```

Expected output:
```text
--------------------
Added bullet to: Capo CLI
--------------------
```
---

### Editing a record: `edit`

Edits an existing record. You can update one or more fields without affecting the rest.

Format:
`edit RECORD_INDEX [NEW_TITLE] [/role NEW_ROLE] [/tech NEW_TECH] [/from YYYY-MM] [/to YYYY-MM]`

Notes:
- You can provide any combination of the fields.
- Fields not specified will remain unchanged.
- Date format must follow `YYYY-MM`.
- End date cannot be earlier than start date.

Examples:

Edit only tite:
```text
edit 1 New Capo CLI
```

Edit role and tech:
```text
edit 1 /role Team lead /tech Java
```

Edit dates:
```text
edit 1 /from 2025-12 /to 2024-04
```

Edit multiple fields:
```text
edit 1 Capo CLI /role Lead Developer /tech Java /from 2026-01 /to 2026-05
```

Expected output:
```text
--------------------
Record 1 updated.
--------------------
```

---

### Editing a bullet: `editBullet`

Edits an existing bullet poiint within a record.

Format: `editBullet RECORD_INDEX BULLETINDEX / NEW_BULLET_TEXT`

Notes:
- Both record and bullet indexes are 1 based.
- The `/` operator is required before the new bullet text.
- The bullet text cannot be blank.

Example:
```text
editBullet 1 2 / Improved performance by optimizing algorithms
```

Expected Output:
```text
--------------------
Edited bullet 2 in record 1
Records saved to file
--------------------
```
---

### Editing a user: `edituser`

Edits current user attribute which is displayed in resume.

Format: `edituser ATTRIBUTE`

Notes:
- Can only be one of the three attributes, name, number or email.
- Can only edit one attribute at a time.

Example:
```text
edituser name
```

Expected Output:
```text
--------------------
Current Name: CURRENT_NAME
What would you like to change it too?
--------------------
```

---
### Finding records by keyword : `find`

Finds records whose title, role, tech, start date, or end date contains the keyword.

Format:
`find KEYWORD`

Example:
```text
find java
```

Expected output (example):
```text
--------------------
Matching records:
1. [P] Capo CLI | role: Developer | tech: Java | from: 2026-01 | to: 2026-03
--------------------
```

---

### Finding bullets by keyword : `findbullet`

Finds bullet points containing the keyword across all records.
For each matching record, only matching bullets are shown.

Format:
`findbullet KEYWORD`

Example:
```text
findbullet persistent
```

Expected output (example):
```text
1. [P] Capo CLI | role: Developer | tech: Java | from: 2026-01 | to: 2026-03
Bullets:
  1. Implemented persistent storage with file IO
```

---

### Moving a bullet : `movebullet`

Moves a bullet from one position to another within the same record.

Format:
`movebullet RECORD_INDEX FROM_BULLET_INDEX TO_BULLET_INDEX`

Example:
```text
movebullet 1 3 1
```

Expected output:
```text
--------------------
Bullet 3 moved to position 1 in record 1.
--------------------
```

---

### Sorting records by title : `sort`
Sorts all records alphabetically by title.
 
Format:
`sort`
 
Example:
```text
sort
```
 
Expected output:
```text
--------------------
Records sorted alphabetically by title.
--------------------
```
 
---

### Generating resume : `generate`
Displays a formatted resume view with your user information and all records grouped by type (CCA, Experience, Project).
 
Format:
`generate`
 
Example:
```text
generate
```
 
Expected output:
```text
John
Number: 91234567
Email: john@example.com
--------------------
Cca
--------------------
[C] Chess Club
  Role: President | Tech: None
  2023-01 to 2024-01
--------------------
Experience
--------------------
...
```
 
---

### Exiting the program : `bye`

Exits ResuMake.

Format:
`bye`

Example:
```text
bye
```

Expected output:
```text
--------------------
bye
--------------------
```

---

## FAQ

**Q: How do I move my ResuMake data to another computer?**  
**A:** Copy the `records.txt` file from your current project folder to the same location in the new machine’s project folder.

**Q: Why does ResuMake show `Unknown command.`?**  
**A:** The command format is invalid or incomplete. Check spelling, required parameters, and flag order (for add record commands: `/role /tech /from /to`).

**Q: I edited/deleted the wrong item. Can I undo it?**  
**A:** There is no undo command currently. If needed, manually fix the record using `edit`/`editbullet`, or restore from a backup copy of `records.txt`.

---

## Command Summary

| Command | Format |
|---|---|
| `list` | `list` or `list TYPE` |
| `project` | `project TITLE /role ROLE /tech TECH /from YYYY-MM /to YYYY-MM` |
| `experience` | `experience TITLE /role ROLE /tech TECH /from YYYY-MM /to YYYY-MM` |
| `cca` | `cca TITLE /role ROLE /tech TECH /from YYYY-MM /to YYYY-MM` |
| `show` | `show RECORD_INDEX` |
| `find` | `find KEYWORD` |
| `findbullet` | `findbullet KEYWORD` |
| `addbullet` | `addbullet RECORD_INDEX / BULLET_TEXT` |
| `edit` | `edit RECORD_INDEX [NEW_TITLE] [/role NEW_ROLE] [/tech NEW_TECH] [/from YYYY-MM] [/to YYYY-MM]` |
| `editbullet` | `editbullet RECORD_INDEX BULLET_INDEX / NEW_BULLET_TEXT` |
| `movebullet` | `movebullet RECORD_INDEX FROM_BULLET_INDEX TO_BULLET_INDEX` |
| `delete` | `delete RECORD_INDEX` |
| `deletebullet` | `deletebullet RECORD_INDEX BULLET_INDEX` |
| `sort` | `sort` |
| `generate` | `generate` |
| `bye` | `bye` |

---

## Saving

ResuMake saves records to:

```text
records.txt
```

Records are loaded on startup and saved automatically after every valid command.
