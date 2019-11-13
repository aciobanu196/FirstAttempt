# Changelog for FirstAttempt project 

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

##[0.0.1] - 2019-11-12

### Added

- db.migration directories
- V1_CREATE_TABLES.sql file
- flyway plugin

### Changed

- sbt.build file changed in order to be able to migrate files 