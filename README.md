# SimpleServerTransferHytale

**SimpleServerTransferHytale** is a lightweight utility mod/plugin for Hytale Server that allows you to transfer players to another server using a simple command.

Perfect for testing multi-server setups, gateways, and server switching without a full proxy.

---

## ✨ Features

- ✅ Transfer yourself to any server using **IP:PORT**
- ✅ Optional console support (send a specific player)
- ✅ Lightweight & simple (no external dependencies)
- ✅ Great for early network testing / debugging

---

## 📌 Commands

### Player usage
```txt
/st <ip:port>
```

Example:
```txt
/st 127.0.0.1:5520
```

### Console usage
```txt
st <ip:port> --targetPlayer=<name>
```

Example:
```txt
st 127.0.0.1:5520 --targetPlayer=Hytale
```

### Aliases
- `/st`
- `/simpleservertranfer`

---

## 📦 Installation

1. Download the latest `.jar` from **Releases**
2. Put the jar inside your server:
   ```txt
   /mods/
   ```
3. Restart the server
4. Use:
   ```txt
   /st <ip:port>
   ```

---

## ✅ Compatibility

- Requires **Hytale Server**
- Java **25+** required

---

## 🛠️ Building (Developers)

### Requirements
- **Java 25**
- Gradle

### Build steps

Clone the repository with the following command:
```bash
$ git clone https://github.com/Happyuky7/SimpleServerTransferHytale.git
```

Once downloaded in the git terminal use the following command:

```bash
$ cd SimpleServerTransferHytale
```

Now inside the directory you execute the following maven command:
```bash
./gradlew clean build 
```

Jar output:
```txt
build/libs/SimpleServerTransferHytale-<version>.jar
```

---

## Join us

* Feel free to open a PR! We accept contributions.
* [Discord](https://discord.gg/3EebYUyeUX)

---

## Aditional Information

[My website](https://happyuky7.com), My website

[Discord](https://discord.gg/3EebYUyeUX), Support My Server Discord

---

## Contributors

- [**Happyuky7**](https://github.com/Happyuky7) - Main Developer and Maintainer.

---


## Special Thanks To

![IntelliJ IDEA logo](https://resources.jetbrains.com/storage/products/company/brand/logos/IntelliJ_IDEA_icon.png?size=100px)
![IntelliJ IDEA logo](https://resources.jetbrains.com/storage/products/company/brand/logos/IntelliJ_IDEA.png)
![Azul Java logo](https://www.azul.com/wp-content/themes/azul/dist/img/logo.svg)

[IntelliJ IDEA](https://www.jetbrains.com/idea/), Code editor for Java and other programming languages and programs.

[Azul Java](https://www.azul.com/) The world’s largest commercial provider of OpenJDK
