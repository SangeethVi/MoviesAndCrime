create external table crime(year double, population double, totalviolent double, violentrate double, murderrate double, raperate double, robberyrate double, assaultrate double, propertyrate double, burglaryrate double, theftrate double, mvtrate double) row format delimited fields terminated by ','
location '/user/clg469/hiveProject/';

select year, greatest(murderrate, raperate, robberyrate, assaultrate, propertyrate, burglaryrate, theftrate, mvtrate) as maxrate from crime;

select population from crime;