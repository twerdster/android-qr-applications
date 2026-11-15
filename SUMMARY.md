# Android QR applications: maintenance context

Read this file, then SKILL.md, README.md and PROVENANCE.md before making changes. Current documentation update: 15 November 2026.

QRoom is a recovered Android QR client with a PHP/MySQL campus-information backend by Tamir Buchris and Vitaly Kleynik, supervised by Aaron Wetzler. The public snapshot contains 81 source files: 79 unchanged imports and two sanitized database configurations. Missing resources, scanner dependencies and database definitions prevent a complete build. Static inspection found SQL injection, missing application-level authentication and CSRF checks, and database-supplied content evaluated as PHP. Do not deploy this archival backend.

Vitaly approved keeping the archival project page and repository on 12 November 2026; Tamir approved keeping them on 15 November 2026. README.md links to PROVENANCE.md for individual permission scope. No blanket license, new source import or build/runtime evidence is added. Preserve student attribution, existing notices, original figure and all source bytes. Keep correspondence, contact details, raw configurations and the recovery manifest private.
