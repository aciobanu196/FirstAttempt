# Changelog for Ecommerce app 

## [0.3.0] - 2019-11-20
### Added
- added samples, some fixes, added runnable in API module, added configs

## [0.0.1] - 2019-11-11
### Added
- .gitignore file
- version.sbt file
- comments to various classes to the code
- new plugins.sbt file in order to add the scalafmt plugin
### Changed
- The ShopService class and the Routes class as they require more work

## [0.0.1] - 2019-11-12
### Added

- Dependencies.scala object
- api module
- model module
- persistence module
- services module

### Changed

- build.sbt file updated with a new configuration for dependencies
- BuildInfo to include gitCommitHead value
- removed the iml files

##[0.0.1] - 2019-11-13

### Added

- db.migration directories
- V1_CREATE_TABLES.sql file
- flyway plugin

### Changed

- sbt.build  

##[0.1.0] - 2019-11-14

### Added
- new file V2__INSERT INTO TABLES.sql in order to see that the data is being populated successfully

### Changed
- the version to 0.1.0 as a new minor piece of functionality was added
- the location of the .sql migration file
- the configuration of the build.sbt file in order to respect the new location of the migration file

### Removed
- the migration directories db and migration
- the migration file from api module  

###[0.2.0] - 2019-11-15

### Added

- models of the tables
- tables schema
- independent location of the used variables

### Changed

- the version to 0.2.0 as a new minor piece of functionality was added
- the table definitions in V1_CREATE_TABLE

###[0.2.0] - 2019-11-18

### Added

- first part of queries which will be used for building the services 

###[0.3.1] - 2019-11-20

### Changed

- migration files V1_CREATE TABLES.sql and V2_INSERT INTO TABLES files
- Table models
- Table persistence

### Removed

- Bank and Types tables

###[0.4.0] - 2019-11-20

### Added

- Sorting by type asc and desc methods in services 

###[0.4.1] - 2019-11-20

### Changes

- Added small changes to the service files

### [0.4.2] - 2019-11-21

### Changes

- Changes to the migration files 