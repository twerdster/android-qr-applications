<?php

// Recovery change: private deployment values are supplied by the environment.
define("DB_SERVER", getenv("QROOM_DB_SERVER") ?: "localhost");
define("DB_USER", getenv("QROOM_DB_USER") ?: "REPLACE_WITH_DATABASE_USER");
define("DB_PASS", getenv("QROOM_DB_PASS") ?: "REPLACE_WITH_DATABASE_PASSWORD");
define("DB_NAME", getenv("QROOM_DB_NAME") ?: "REPLACE_WITH_DATABASE_NAME");

?>
