FROM openjdk:12-alpine

WORKDIR /home/source/br-test-app/
COPY . ./

RUN mkdir -p /home/dist \
    && ./gradlew --no-daemon build \
    && unzip -d /home/dist/ ./build/distributions/br-test-app.zip

WORKDIR /home/
CMD [ "/home/dist/br-test-app/bin/br-test-app" ]
