# Custom Validators
Custom validators for Spring and Hibernate Application
1)	# @UniqueKey : field validator for validating duplicate field value like duplicate email, mobile No. etc.
Usage : 
	@UniqueKey(className=EntityClass.class, columnName=FieldName, message=ErrorMessage)
