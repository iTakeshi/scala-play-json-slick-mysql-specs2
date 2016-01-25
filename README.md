Scala play sample application
==============================

Very simple example application using:

* scala (2.11)
* play (2.4)
* play-json
* slick (3.1)
* specs2

### Try it!

* Install mysql
* create mysql user `sample` with empty password (!! not recommended; this is a sample application !!)
* create mysql database `scala_play_sample`
* `./activator run`
* open `http://localhost:9000` in your browser
* click `Apply this script now!` to execute SQL script

... and you would see an empty json list.

### Test

Before run the test suite, you must insert a dummy record to `country` table:
```sql
USE scala_play_sample;
INSERT INTO country (id, name, capital) VALUES (1, "Japan", "Tokyo");
```
then `./activator test`
