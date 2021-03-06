# BR Test App

A basic app for storing **Show** items and related **Asset** items that can be video assets, image assets, or ad assets. A "Storage" layer is implemented with an in-memory thread-safe store, and the "Logic" layer is implemented providing container objects.

- As a demo, the [main program][brtestapp-main-file] stores some entries, produces an intermediate "container" object, and formats & prints the container.
- The [brtestapp.logic][brtestapp-logic-dir] package implements the logic layer, which provides container objects for rendering objects from storage.
- The [brtestapp.storage][brtestapp-storage-dir] package implements the storage layer, which is built as a basic thread-safe store, and is directly consumed from the top level.
- The [brtestapp.lib.data][brestapp-lib-data-dir] package contains the immutable POJO classes for the assets and shows objects.

##### Sample Output

```
Show:
        Id: -8083137316828919050
        Name: Mr. Bean
        Description: A British sitcom starring Rowan Atkinson.

Asset:
        Id: -5613201416530659508
        OwnerShowId: -8083137316828919050
        Name: mr-bean-default-image
        Type: image
        Url: https://via.placeholder.com/150
        Expiration: 2147385600

        Id: -6917824394542222203
        OwnerShowId: -8083137316828919050
        Name: mr-bean-ad
        Type: ad
        Url: https://youtu.be/XUSpZ9IKdFg
        Expiration: 2147385600
        Product Description: The best show.

        Id: -5025546413631648670
        OwnerShowId: -8083137316828919050
        Name: mr-bean-poster-1
        Type: image
        Expiration: 2147385600
        Base Image Asset Id: -5613201416530659508

        Id: -5099710883015432285
        OwnerShowId: -8083137316828919050
        Name: mr-bean-s1e1
        Type: video
        Url: https://youtu.be/iIaMLosX_kQ
        Expiration: 2147385600
        Video Type: episode

```

## Usage

### Docker (recommended)

Build image directly from GitHub:

```sh
docker build --tag slib53/br-test-app:1.2.1 https://github.com/SLIB53/br-test-app.git#v1.2.1
```

Run:

```sh
docker run slib53/br-test-app:1.2.1
```

Additionally, the docker container has both the source (`/home/source`) and distributable (`/home/dist`). You can run a container for a development sandbox by running the image interactively:

```sh
docker run -it --entrypoint sh slib53/br-test-app:1.2.1
```

### Local

Requirements:

- JDK 11+

To run locally, clone this repository and use the gradle wrapper:

```sh
br-test-app $ ./gradlew run
```

[brtestapp-main-file]: ./src/main/java/brtestapp/BRTestApp.java
[brtestapp-logic-dir]: ./src/main/java/brtestapp/logic/
[brtestapp-storage-dir]: ./src/main/java/brtestapp/storage/
[brestapp-lib-data-dir]: ./src/main/java/brtestapp/lib/data/
