# Changelog for Ecommerce app 

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

## [0.3.0] - 2019-11-20
### Added
- added samples, some fixes, added runnable in API module, added configs

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

### [0.4.3] - 2019-11-21

### Changes

- One user many carts relationship in migration file and in model/persistence
- Modified the model/persistence files

### [0.4.4] - 2019-11-21

### Changes

- Changed IS_DELETED from BIT to TINYINT(1)<->Boolean

### [0.5.0] - 2019-11-21

### Added

- Added CART - PRODUCT many to many relationship model + persistence + migration changes

### Changed

- CartT and ProductT in persistence

### [0.5.1] - 2019-11-21

### Changed

- persistence and service changes to respect the norm

### [0.5.2] - 2019-11-21

### Removed

- removed deprecated files from persistence and services 

### [0.5.3] - 2019-11-21

### Changed
- minor changes to the services

###[0.5.4] - 2019-11-22

### Changed

- changes to the post and put methods in CartRepository
- changed the CartProduct table
- changed the migration filed
- changed the CartService

### [0.5.5] - 2019-11-22

### Changed

- changed the post method - currently encountering an error
- changed the service files 
- changed the cart table in the migration file

### [0.6.0] - 2019-11-22

### Added

- Order repository
- Started the implementation of the validation - Solved quantity validation and balance validation with status updates

### [0.6.1] - 2019-11-25

### Changed

- Changes to the POST method
- Changes to the routes and the services

