# BR Test App

## Usage

### Docker (recommended)

Build image directly from github:

```sh
docker build --tag slib53/br-test-app:1.0.0 https://github.com/SLIB53/br-test-app.git#v1.0.0
```

Run image on Docker:

```
docker run slib53/br-test-app:1.0.0
```

### Local

#### Requirements

- JDK 11+

To run locally, clone this repo and use the gradle wrapper.
```sh
br-test-app $ ./gradlew run
```
