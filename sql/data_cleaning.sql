-- DATA CLEANING
-- 1. remove duplicates
-- 2. standardize the data
-- 			spelling issues, same units, uniform rules
-- 3. null values
-- 			populate if you can
-- 4. remove unecessary columns and rows if you can





use world_layoffs;
show tables;
select * 
from layoffs
;



-- staging starts empty
-- we use it because we want the raw data untouched if anything goes wrong while cleaning
drop table if exists layoffs_staging;
create table layoffs_staging 
like layoffs
;

select * 
from layoffs_staging
;

insert layoffs_staging
select * 
from layoffs
;