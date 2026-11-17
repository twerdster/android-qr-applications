# Updated browser example

Added 17 November 2026 as a new, project-specific interaction. It is separate from the recovered software and is not the students' implementation.

## What runs

Inspect sample QR payloads, look up fictional rooms, change the schedule time and export local room data.

The sample QR codes encode `qroom:101`, `qroom:202` and `qroom:303`. **Use this QR payload** fills in the known text; it does not scan an image or access the camera. The parser accepts only `qroom:<digits>` and rejects unknown rooms. These new local records contain no campus or personal information.

## Run

Open https://twerdster.github.io/android-qr-applications/ or serve the repository's `docs/` directory with any static HTTP server. For example, from the repository root:

```sh
python3 -m http.server 8000 --directory docs
```

Open `http://localhost:8000`. The demo uses standard Canvas 2D and local browser controls. No additional demo packages, SDKs or credentials are required. Downloads are generated JSON files. No camera permission is requested.

## Implementation

`docs/index.html` contains the controls and factual scope labels; `docs/demo.js` implements the interaction; `docs/demo.css` contains the responsive layout. All generated images/data are illustrative. The sample button selects known QR text; it does not scan a camera image. The recovered PHP backend has SQL-injection, authentication/CSRF and `eval` defects: do not deploy it. The demo never contacts it.

## Recorded checks

[VALIDATION.json](VALIDATION.json) records 13 passed browser assertions on the new interaction, JSON export where present, local-only requests, error-free JavaScript and a 390-pixel responsive layout. These are interaction assertions on generated/local examples, not accuracy or compatibility benchmarks. Original native application/hardware coverage is unchanged; see [historical recovery notes](../docs/RECOVERY.md).

## Attribution and terms

Original project: Tamir Buchris, Vitaly Kleynik. Supervision: Aaron Wetzler. The new browser example was prepared with Codex assistance in November 2026; Claude reviewed the README wording and factual scope. The new files have a [scoped MIT license](../docs/DEMO-LICENSE.txt); it does not relicense historical code, images, slides, reports or third-party dependencies.

The three sample QR SVGs were generated with python-qrcode 8.2 from the literal payloads `qroom:101`, `qroom:202` and `qroom:303`. The generator is not required at runtime. The demo does not decode QR images.

All three displayed QR SVGs were rendered and independently decoded with a separate QR decoder, recovering exactly their intended `qroom:101`, `qroom:202` and `qroom:303` payloads. This checks the sample assets; it does not add a scanner to the browser demo.
