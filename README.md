## ExcelReplaceAll

ExcelReplaceAll is replaceAll for Excel using Apache POI.

## Requirements

  * JRE
  * ANT

## Getting Started

1. Check out ExcelReplaceAll

    ~~~ sh
    $ git clone git://github.com/shinoburc/ExcelReplaceAll
    ~~~

2. Compile

  ~~~ sh
  $ cd ExcelReplaceAll
  $ ant
  ~~~

3. Copy Excel for replace strings.

  ~~~ sh
  $ cp /hoge/fuga.xls xls-input/.
  ~~~

4. Configure

  ~~~ sh
  $ echo "hello=world" >> src/application.ini
  ~~~

5. Run

  ~~~ sh
  $ ant run
  ~~~

6. Check

  ~~~ sh
  $ open xls-output/hello.xls
  ~~~


Have fun!


## etc

Deletes all build files.

  ~~~ sh
  $ ant clean
  ~~~
