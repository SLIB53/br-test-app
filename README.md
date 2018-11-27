# BR Test App

Implements a [simple data store](./src/main/java/brtestapp/storage/BRTestAppStore.java) for storing **Shows** and related **Assets** that can be video assets, image assets, or ad assets. Each asset type contains a related asset metadata type. All type definitions can be found in the [brtestapp.lib.data](./src/main/java/brtestapp/lib/data/) package.

As a demo, the [main program](./src/main/java/brtestapp/BRTestApp.java) creates some entries, produces an intermediate "container" object, and formats an output of the show and assets added.

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
docker build --tag slib53/br-test-app:1.0.1 https://github.com/SLIB53/br-test-app.git#v1.0.1
```

Run:

```sh
docker run slib53/br-test-app:1.0.1
```

Additionally, the container contains both the source (`/home/source`) and distribution (`/home/dist`). You can access the container for a development sandbox by running the image interactively:

```sh
docker run -it --entrypoint sh slib53/br-test-app:1.0.1
```

### Local

Requirements:

- JDK 11+

To run locally, clone this repo and use the gradle wrapper:

```sh
br-test-app $ ./gradlew run
```
