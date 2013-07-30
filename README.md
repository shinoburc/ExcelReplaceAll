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

2. Copy Excel for replace all strings.

  ~~~ sh
  $ cd ExcelReplaceAll
  $ cp /hoge/hello.xls xls-input/.
  ~~~

3. Configure

  ~~~ sh
  $ echo "hello=world" >> src/application.ini
  ~~~

4. Compile

  ~~~ sh
  $ ant
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
