# XC

XML Command Line Tool

XC is a command line tool for reading and writing XML files. It allows you to get the value of an element, get the attributes of an element, and set the value of an element. This can be useful for bash scripts and other command line tools.

## Usage

```
java -jar xc.jar -f=example.xml -l=element/subelement-m=get
```

This will read the file `example.xml` and get the value of the element `element/subelement`.

## Options

- `-f` or `--file`: The file to read or write to.
- `-l` or `--location`: The location of the element to read or write to. Use `/` to separate elements.
- `-m` or `--mode`: The mode to use. Can be `get`, `set`, or `get-attr`.
- `-i` or `--input`: The input to set the element to. Only used in `set` mode.

## Examples

```
java -jar xc.jar -f=example.xml -l=element/subelement -m=get
```

This will read the file `example.xml` and get the value of the element `element/subelement`.

```
java -jar xc.jar -f=example.xml -l=element/subelement -m=set -i=value
```

This will read the file `example.xml` and set the value of the element `element/subelement` to `value`.

## Licence

This project is licenced under the GNU General Public License v3.0 - see the [LICENSE](LICENSE) file for details.
