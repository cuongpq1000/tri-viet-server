# Hình ảnh này có sẵn Gradle và JDK 17
FROM eclipse-temurin:17-jre-alpine

# Đặt thư mục làm việc trong container là /usr/src/app
WORKDIR /usr/src/app

# Sao chép các file jar da build vao image nay
COPY ./target/triviet-0.0.1-SNAPSHOT.jar ./triviet.jar

# Định nghĩa lệnh để chạy ứng dụng
ENTRYPOINT ["java", "-jar", "./triviet.jar"]