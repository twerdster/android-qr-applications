# android-qr-applications: maintenance context

Read this file, then SKILL.md, README.md and linked recovery/provenance records. Current update: 17 November 2026.

QRoom used QR codes on room entrances to retrieve room, class and lecturer information through an Android client and PHP/MySQL service.

## Original material

The partial archive contains 81 files: 79 unchanged imports and two sanitized database configurations. Required resources, scanner dependencies and database definitions are missing. Original source, submodule pins, images, reports, slides, notices and author-response records are unchanged. [Historical implementation and recovery notes](docs/RECOVERY.md) retain the earlier setup and failed-build evidence; existing PROVENANCE.md or source/PROVENANCE.json remains authoritative where present.

## Updated demo

Inspect sample QR payloads, look up fictional rooms, change the schedule time and export local room data. This is new independent JavaScript/Canvas code in docs/, not a restored or ported historical application. The sample button selects known QR text; it does not scan a camera image. The recovered PHP backend has SQL-injection, authentication/CSRF and eval defects: do not deploy it. The demo never contacts it.

Run https://twerdster.github.io/android-qr-applications/ or `python3 -m http.server 8000 --directory docs` from the repository root. No build, account, SDK or external service is required. Serve docs/ as the GitHub Pages source.

## Checks and review

updated/VALIDATION.json records 13 passing Chromium browser assertions for the new demo, including responsive layout checks; these are scoped interaction checks on synthetic/local examples. No original native build, sensor accuracy or physical-mobile/Safari/Firefox coverage was added. Two Claude CLI editorial passes reviewed the concise README and new-demo guide; useful wording and scope qualifications were checked against code and recovery records. Detailed review records are private.

Preserve attribution, original bytes and licensing boundaries. New demo code has a scoped MIT license in docs/DEMO-LICENSE.txt; it does not cover historical materials or third-party dependencies. Correspondence, personal contact data and machine-specific setup details stay private. Before every commit review and synchronize this file and SKILL.md.
