# For huggingface deployment

FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy jar file
COPY appstock.jar appstock.jar

# Hugging Face passes PORT dynamically
ENV PORT=7860

EXPOSE 7860

# Run your Spring Boot app and make it use the PORT variable
CMD ["sh", "-c", "java -jar appstock.jar --server.port=${PORT} --server.address=0.0.0.0"]