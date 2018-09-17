# SONG
SONG Server - Metadata and Validation system 

This module of SONG implements the following functions:

- distributed entity ID generation
- endpoints to accept and validate metadata JSON documents
- CRUD functions for metadata entities 

Contains code adapted from Corey Hulen https://github.com/coreyhulen/earnstone-id
Licensed under Apache License 2.0

Uses Flywaydb to manage database configuration. Be sure to specify an active spring profile in order to select appropriate migration scripts (see application.yml):

    --spring.profiles.active=prod (PostgreSQL)
    --spring.profiles.active=dev  (in-memory h2)

This will eventually be taken care of in the startup bash scripts.
## Build

```bash
mvn clean package
```

Note: inorder to prevent the spring-boot-maven-plugin from overwriting the original jar with the uberjar, the `<classifier>exec</classifier>` attribute was added to the configuration to suffix the uberjar with __exec__
