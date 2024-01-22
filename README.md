# aerztehaus
Ärztehaus-Projekt Berufsschule

## Setting up the project
Just import the GitHub repository into Eclipse.
The database can either be located on a remote server or on the
local machine (e.g. per XAMPP). All you need is access to a MySQL
database into which the `assets/dump.sql` script has been imported.

## Starting the application
The application needs to be launched with 4 command line parameters:
`DB_HOST`, `DB_USER`, `DB_PASSWORD` and `DB_DATABASE`.

Example: `java -jar aerztehaus.jar localhost root secret1337 aerztehaus`

You can also configure those parameters in the "Run configurations"
within the Eclipse IDE.