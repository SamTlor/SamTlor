-- STANDARDIZING DATA
-- finding issues in your data and fixing it

-- some of the company values have trailing " "
select company, trim(company)
from layoffs_staging_2
;

update layoffs_staging_2
set company = trim(company)
;





-- crypto, crypto currency and cryptoCurrency are the same thing
select distinct industry 
from layoffs_staging_2
order by 1
;

select *
from layoffs_staging_2
where industry 
like 'Crypto%'
;

-- so we update it 
update layoffs_staging_2
set industry = 'Crypto'
where industry 
like 'Crypto%'
;

-- and check the results
select distinct industry 
from layoffs_staging_2
order by 1
;



-- one version of united states has a . after it
select distinct country
from layoffs_staging_2
order by 1
;

select distinct country
from layoffs_staging_2
where country 
like "United States%"
;

select distinct country, trim(trailing '.' from country)
from layoffs_staging_2
order by 1
;

update layoffs_staging_2
set country = trim(trailing '.' from country)
where country 
like "United States%"
;






-- dates are challenging
-- %m is month, %d is day, %Y is four number year
select `date`,
STR_TO_DATE(`date`, '%m/%d/%Y')
from layoffs_staging_2
;

update layoffs_staging_2
set `date` = STR_TO_DATE(`date`, '%m/%d/%Y')
;

select `date`
from layoffs_staging_2
;

-- only alter a staging table
alter table layoffs_staging_2
modify column `date` date
;





-- null
update layoffs_staging_2
set industry = null 
where industry = ''
;

select *
from layoffs_staging_2
where industry is null
;

-- industry is '' in one row but 'Travel' in another so we know how to fill the '' value
select *
from layoffs_staging_2
where company = 'Airbnb'
;

-- this finds all the places where a company has one row where the industry is null
-- and another row where the industry is not null
select t1.industry, t2.industry
from layoffs_staging_2 t1
join layoffs_staging_2 t2
	on 
		t1.company = t2.company
		and 
		t1.location = t2.location
where 
	t1.industry is null
	and
	t2.industry is not null
;

update layoffs_staging_2 t1
join layoffs_staging_2 t2 
	on t1.company = t2.company
set t1.industry = t2.industry
where
	t1.industry is null 
	and
	t2.industry is not null
;





-- these have no values for laid off so they're not useful to us
select * 
from layoffs_staging_2
where total_laid_off is null
and 
percentage_laid_off is null
;


delete
from layoffs_staging_2
where total_laid_off is null
and 
percentage_laid_off is null
;





-- now that we're done we can get rid of row_num
alter table layoffs_staging_2
drop column row_num
;

select * 
from layoffs_staging_2
;