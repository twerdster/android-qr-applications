# QR code applications on Android

A campus information system with automatically generated QR codes for lecture rooms, schedules and lecturer information.

Students: Tamir Buchris, Vitaly Kleynik.

Supervision: Aaron Wetzler.

## Status

**Partial original source recovered. Build and run untested.** `source/` contains the student-specific QRoom Java classes, PHP CMS/query code and original Android manifest/platform configuration from the January 2012 handoff. It is not a complete or runnable release.

## Running

The original Android configuration targets API 8 (Android 2.2). The launcher is `technion.ee.softlab.qroom.QRoom.MainActivity`; the application class is `qrRoomsApplication`. The original project used the legacy Android/Eclipse/Ant-era toolchain and a repackaged ZXing scanner. ZXing core/client code, PHP QR Code, Android resources/assets, generated output and APKs are intentionally omitted. No verified original one-command build procedure was recovered.

The backend uses PHP's historical `mysql_*` API and MySQL. No database/schema or personal campus records are included. A November 2026 static audit found SQL injection, missing application-level authentication/CSRF checks, and execution of database-supplied content through `eval`. **Do not deploy this archival backend or expose it to the internet.** Credential removal does not fix these vulnerabilities; the backend needs a security redesign before use. Original Android URLs point to an old institutional service; they were not contacted or validated during recovery.

### Credential Removal

The two `source/{CMS,queries}/includes/constants.php` files originally embedded private deployment values. They are the only modified source files: the original values were replaced with `QROOM_DB_SERVER`, `QROOM_DB_USER`, `QROOM_DB_PASS` and `QROOM_DB_NAME` environment-variable lookups and explicit placeholder defaults. Raw originals remain private. Set these variables only for a separately reviewed local deployment; never commit real values.

Two legacy duplicate Java activities containing personal contact details were omitted. All other imported files retain their original bytes. No student reports, personal records, signing keys, VCS history, vendor code or prebuilt executables are included. Missing scanner classes/resources and the database prevent a complete build/deployment from this subset.

## Links

- [Project entry on Aaron Wetzler's website](https://twerdster.github.io/#qr-code-applications-on-android)

## Attribution and Updates

Original student credits are preserved. No blanket software license has been added; third-party libraries must be obtained under their own terms. Importing a historical snapshot does not establish a complete license grant for every dependency. Original authors can open an issue to contribute updates or request corrections or removal of their material.

