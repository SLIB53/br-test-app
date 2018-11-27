# BR Test App

Implements a [simple data store](./src/main/java/brtestapp/storage/BRTestAppStore.java) for storing **Shows** and related **Assets** that can be video assets, image assets, or ad assets. Each asset type contains a related asset metadata type. All type definitions can be found in the [brtestapp.lib.data](./src/main/java/brtestapp/lib/data/) package.

As a demo, the [main program](./src/main/java/brtestapp/BRTestApp.java) creates some entries, produces an intermediate "container" object, and formats an output of the show and assets added.

##### Sample Output

```
Nov 27, 2018 6:23:26 AM brtestapp.BRTestApp main
INFO:
Show:
        Id: -5751567077610941277
        Name: Mr. Bean
        Description: A British sitcom starring Rowan Atkinson.

Asset:

        Id: -8996539178262142795
        OwnerShowId: -5751567077610941277
        Name: mr-bean-default-image
        Type: image
        Url: https://via.placeholder.com/150
        Expiration: 0

        Id: -6722091173985647966
        OwnerShowId: -5751567077610941277
        Name: mr-bean-ad
        Type: ad
        Url: https://youtu.be/XUSpZ9IKdFg
        Expiration: 0
        Product Description: The best show.

        Id: -5504493667670518906
        OwnerShowId: -5751567077610941277
        Name: mr-bean-s1e1
        Type: video
        Url: https://youtu.be/iIaMLosX_kQ
        Expiration: 0
        Video Type: episode

        Id: -4966934757380976626
        OwnerShowId: -5751567077610941277
        Name: mr-bean-poster-1
        Type: image
        Expiration: 0
        Base Image Asset Id: -8996539178262142795

```

## Usage

### Docker (recommended)

Build image directly from GitHub:

```sh
docker build --tag slib53/br-test-app:1.0.0 https://github.com/SLIB53/br-test-app.git#v1.0.0
```

Run:

```
docker run slib53/br-test-app:1.0.0
```

### Local

Requirements:

- JDK 11+

To run locally, clone this repo and use the gradle wrapper:

```sh
br-test-app $ ./gradlew run
```
