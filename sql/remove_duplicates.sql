-- REMOVE DUPLICATES
-- duplicates are when all of these columns appear together more than once
-- this uses every column but it doesn't need to be that way
select *, row_number() 
over (
	partition by 
		company, location, industry, total_laid_off, percentage_laid_off, `date`,
		stage, country, funds_raised_millions
) as row_num
from layoffs_staging
;

with duplicate_cte as 
(
	select *, row_number() 
	over (
		partition by 
			company, location, industry, total_laid_off, percentage_laid_off, `date`,
			stage, country, funds_raised_millions
	) as row_num
	from layoffs_staging
)
select * 
from duplicate_cte 
where row_num > 1
;

-- double check your work before you delete anything
-- casper is in the database three times but should only be there twice
select *
from layoffs_staging
where company = "Casper"
;



-- we delete by creating another staging table and filling it with only the data that we want
drop table if exists layoffs_staging_2;
CREATE TABLE `layoffs_staging_2` (
  `company` text,
  `location` text,
  `industry` text,
  `total_laid_off` int DEFAULT NULL,
  `percentage_laid_off` text,
  `date` text,
  `stage` text,
  `country` text,
  `funds_raised_millions` int DEFAULT NULL,
  `row_num` int
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

select * 
from layoffs_staging_2
;

insert into layoffs_staging_2
select *, row_number()
over (
	partition by 
		company, location, industry, total_laid_off, percentage_laid_off, `date`,
		stage, country, funds_raised_millions
) as row_num
from layoffs_staging
;

select * 
from layoffs_staging_2
where row_num > 1
;

delete  
from layoffs_staging_2
where row_num > 1
;



-- 
select * 
from layoffs_staging_2
;