FROM maven:3.9.9-sapmachine-22 AS build

WORKDIR /app

COPY . .

USER root

RUN mvn install -Dmaven.test.skip=true && \
    mvn package -Dmaven.test.skip=true

# Hình ảnh này có sẵn Gradle và JDK 17
FROM eclipse-temurin:17-jre-alpine

# Đặt thư mục làm việc trong container là /usr/src/app
WORKDIR /app

# Sao chép các file jar da build vao image nay
COPY --from=build /app/target/triviet-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

# Định nghĩa lệnh để chạy ứng dụng
ENTRYPOINT ["java", "-jar", "./triviet-0.0.1-SNAPSHOT.jar"]
