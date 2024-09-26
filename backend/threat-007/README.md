# Spring Boot Project

This is a Spring Boot project built using Maven 3.9.x and JDK 17. The project is configured to connect to a MongoDB database, requiring environment variables for `MONGO_USERNAME` and `MONGO_PASSWORD`. The application uses the `dev` profile for development purposes.

## **Prerequisites**

- **JDK 17**: Ensure you have JDK 17 installed. You can download it from [AdoptOpenJDK](https://adoptopenjdk.net/) or [Oracle JDK](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).
- **Maven 3.9.x**: Download and install Maven 3.9 from [Maven's official site](https://maven.apache.org/download.cgi).
- **MongoDB**: Make sure you have access to a MongoDB instance (local or MongoDB Atlas).

## **Project Setup**

Follow the steps below to set up the Spring Boot project on your local machine.

### **1. Install JDK 17**

- Download and install JDK 17 from [AdoptOpenJDK](https://adoptium.net/) or [Oracle JDK](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).
- **Set the `JAVA_HOME` environment variable**:
  - **Windows**:
    1. Open Command Prompt and run:
       ```cmd
       setx JAVA_HOME "C:\Program Files\Java\jdk-17"
       ```
    2. Add `JAVA_HOME\bin` to your PATH:
       - Open **Control Panel** → **System** → **Advanced system settings** → **Environment Variables**.
       - Find `Path` and click **Edit**. Add `C:\Program Files\Java\jdk-17\bin`.
  - **macOS/Linux**:
    1. Add the following lines to your `~/.bashrc` or `~/.bash_profile`:
       ```bash
       export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home
       export PATH=$PATH:$JAVA_HOME/bin
       ```
    2. Apply the changes:
       ```bash
       source ~/.bashrc   # or source ~/.bash_profile
       ```

### **2. Install Maven 3.9.x**

- Download Maven 3.9.x from [Maven's official website](https://maven.apache.org/download.cgi).
- Extract the Maven archive to a directory (e.g., `C:\Program Files\apache-maven-3.9.x`).

- **Add Maven to the PATH**:
  - **Windows**:
    1. Open **Control Panel** → **System** → **Advanced system settings** → **Environment Variables**.
    2. Edit the `Path` variable and add `C:\Program Files\apache-maven-3.9.x\bin`.
  - **macOS/Linux**:
    1. Add the following to your `~/.bashrc` or `~/.bash_profile`:
       ```bash
       export PATH=$PATH:/path/to/apache-maven-3.9.x/bin
       ```
    2. Apply the changes:
       ```bash
       source ~/.bashrc   # or source ~/.bash_profile
       ```
- Verify Maven installation by running:
  ```bash
  mvn -v

### **3. Install Dependencies**
```bash
mvn clean install
```
### **4. Configure App in IntelliJ IDEA**
- Open IntelliJ IDEA and load the project by selecting the pom.xml file.
- Go to Run → Edit Configurations.
- Create or select a Spring Boot configuration.
- Set the Active Profile to ```dev```.
- Add the environment variables for MongoDB in the "Environment variables" section. Configuring IntelliJ IDEA
  - MONGO_USERNAME
  - MONGO_PASSWORD
 
### **5. Running the Application**
- You can start the application either via IntelliJ by clicking the Run button or using the following Maven command:
```bash
mvn spring-boot:run
```
###**6. Accessing the Application**
- The Spring Boot application will be available at:
```arduino
http://localhost:8080
```


