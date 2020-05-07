create external table crime(year double, population double, totalviolent double, violentrate double, murderrate double, raperate double, robberyrate double, assaultrate double, propertyrate double, burglaryrate double, theftrate double, mvtrate double) row format delimited fields terminated by ','
location '/user/clg469/hiveProject/';

create table highestrates as
select year, greatest(murderrate, raperate, robberyrate, assaultrate, propertyrate, burglaryrate, theftrate, mvtrate) as maxrate from crime;

create external table crimemovies(year double, crimemovies double, totalmovies double, cmrate double) row format delimited fields terminated by '|'
location '/user/clg469/movies/';

create table dividebycmrate as
SELECT crime.violentrate / crimemovies.cmrate AS result 
FROM crime INNER JOIN crimemovies
ON (crime.year=crimemovies.year);

select AVG(result) from dividebycmrate;

create table murderbycmrate as
SELECT crime.murderrate / crimemovies.cmrate AS result 
FROM crime INNER JOIN crimemovies
ON (crime.year=crimemovies.year);

select AVG(result) from murderbycmrate;

create table assaultbycmrate as
SELECT crime.assaultrate / crimemovies.cmrate AS result 
FROM crime INNER JOIN crimemovies
ON (crime.year=crimemovies.year);

select AVG(result) from assaultbycmrate;
