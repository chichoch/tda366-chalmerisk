# ChalmeRisk

A Risk board game clone built with Java Swing.

## Project Overview

- **Type:** Eclipse Java project (no build tool like Maven/Gradle)
- **Target JDK:** Java SE 1.6 (source & target compliance)
- **Main class:** `edu.chl.chalmerisk.risk.Main`
- **Architecture:** MVC — packages `core`, `ctrl`, `view`, `io`
- **Dependencies:** Only JDK standard library (Swing for GUI) + JUnit 4 (tests only)

## Option 1: Run from the command line

Since this is a pure Java/Swing project with no external dependencies, you can compile and run it directly.

### 1. Compile all sources

```bash
cd ChalmeRisk
mkdir -p bin
find src -name "*.java" > sources.txt
javac -d bin @sources.txt
```

> **Note:** The project originally targeted Java 6, but the code is simple enough to compile fine on a modern JDK.

### 2. Copy resources into the classpath

The code loads images and maps relative to the working directory or classpath:

```bash

cp -r resources/* bin/
cp -r maps/* bin/
```

### 3. Run the game

```bash
java -cp bin edu.chl.chalmerisk.risk.Main
```

## Option 2: Import into an IDE

### Eclipse

1. **File → Import → General → Existing Projects into Workspace**
2. Set the root directory to the repository root
3. Select **ChalmeRisk** from the detected projects
4. Click **Finish** — Eclipse will read `.classpath` and `.project` automatically
5. Right-click `Main.java` → **Run As → Java Application**

### IntelliJ IDEA

1. **File → Open** → select the `ChalmeRisk` directory
2. IntelliJ will detect the Eclipse project files and offer to import
3. Configure the project SDK (any JDK 6+ will work)
4. Right-click `Main.java` → **Run 'Main.main()'**

### VS Code

1. Install the **Extension Pack for Java**
2. Open the `ChalmeRisk` folder
3. The Java extension will read `.classpath` and configure the project
4. Open `Main.java` → click the **Run** button above the `main` method

## Troubleshooting

| Issue                                | Fix                                                                                                                        |
| ------------------------------------ | -------------------------------------------------------------------------------------------------------------------------- |
| `FileNotFoundException` at startup   | Run from inside the `ChalmeRisk/` directory so relative paths to `resources/` and `maps/` resolve correctly                |
| Compilation errors with `--source 6` | Drop the source/target flags — modern JDK compiles Java 6 code fine without them                                           |
| Images not showing in GUI            | Ensure `resources/` contents are on the classpath or in the working directory                                              |
| `javax.swing` not found (JDK 11+)    | Swing is still included in standard JDK distributions. If using a minimal JRE, ensure the `java.desktop` module is present |
