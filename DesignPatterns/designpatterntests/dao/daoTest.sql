DROP TABLE NutritionInfo IF EXISTS;;
DROP TABLE Product IF EXISTS;;
DROP TABLE StdNutrition IF EXISTS;;

CREATE TABLE StdNutrition(
  Code VARCHAR(10) PRIMARY KEY,
  Amount numeric(6,2) NOT NULL,
  Unit VARCHAR(10) NOT NULL,
  Unique(Amount, Unit)
);;

CREATE TABLE Product(
  Code VARCHAR(20) PRIMARY KEY,
  Name varchar(50) NOT NULL,
  EntryDate TIMESTAMP NOT NULL,
  Amount numeric(6,2) NOT NULL,
  Unit varchar(10) NOT NULL,
  Quantity INT NOT NULL,
  StdNutritionCode VARCHAR(10) NOT NULL,
  FOREIGN KEY(StdNutritionCode) REFERENCES StdNutrition(Code)
);;

CREATE TABLE NutritionInfo(
  ProductCode VARCHAR(20),
  Name VARCHAR(50),
  Amount NUMERIC(6,2) NOT NULL,
  Unit VARCHAR(10) NOT NULL,
  PRIMARY KEY(ProductCode, Name),
  FOREIGN KEY(ProductCode) REFERENCES Product(Code)
);;

INSERT INTO StdNutrition VALUES('100g', 100, 'g');;
INSERT INTO StdNutrition VALUES('100ml', 100, 'ml');;

INSERT INTO Product VALUES('CB1', 'Chocolate Bar 1', '2015-12-10 11:21:00.000000000', 49.00, 'g', 1, '100g');;
INSERT INTO NutritionInfo values('CB1', 'Energy', 2200, 'kJ');;
INSERT INTO NutritionInfo values('CB1', 'Protein', 12.3, 'g');;
INSERT INTO NutritionInfo values('CB1', 'Fat', 24.5, 'g');;
INSERT INTO NutritionInfo values('CB1', 'Carbohydrate', 54, 'g');;

INSERT INTO Product VALUES('BB1', 'Breakfast Bar 1', '2016-02-01 11:21:00.000000000', 200.00, 'g', 6, '100g');;
INSERT INTO NutritionInfo values('BB1', 'Energy', 1400, 'kJ');;