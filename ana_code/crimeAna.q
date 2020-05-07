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

create table predictcrime as
select crime.violentrate, 1176.2858451486848 * crimemovies.cmrate AS result 
FROM crime INNER JOIN crimemovies
ON (crime.year=crimemovies.year);

create table crimepercentdiff as
select (result-violentrate)/violentrate as result
from predictcrime;

create table predictmurder as
select crime.murderrate, 14.38742159017673 * crimemovies.cmrate AS result 
FROM crime INNER JOIN crimemovies
ON (crime.year=crimemovies.year);

create table murderpercentdiff as
select (result-murderrate)/murderrate as result
from predictmurder;

create table predictassault as
select crime.assaultrate, 731.6848657347505 * crimemovies.cmrate AS result 
FROM crime INNER JOIN crimemovies
ON (crime.year=crimemovies.year);

create table assaultpercentdiff as
select (result-assaultrate)/assaultrate as result
from predictassault;
