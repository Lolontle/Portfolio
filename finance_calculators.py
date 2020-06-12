import math
# We import the math module so we can later use the power function
type_of_calculator = input("Which calculation would you like to do? (Bond or Investment) ")
# Ask the user to input which type of calculation would they like to perform
if type_of_calculator == ("bond"):
    value_of_house = float(input("What is the value of the house? R"))
    interest_bond = float(input("What is the annual interest rate, without the % sign? "))
    time_bond = int(input("How many months do you plan on repaying the bond? "))
# If the type of calculation is bond then the program must ask the user for the value of the house they would like to purchase, the amount of interest on the value of the house and how long they would like to pay back the loan
    interest_bond = round((interest_bond/12) + 1, 1)
    total_bond = 1 - math.pow((1 + interest_bond), -time_bond)
    total_bond = interest_bond/total_bond
    total_bond = round(total_bond * value_of_house, 2)
    print("The amount you have to pay for " + str(time_bond) + " months at the interest rate of " + str(interest_bond) + " is R" + str(total_bond) + " per month.")
# The calculations start with dividing the interest rate by 12 and adding one to the answer and rounding off the answer to 1 decimal point
# decreasing the addition of 1 to the interest of the bond to the power of negative the time inputted to repay the bond
# Take the interest rate and divide it by the total bond
# Then multiply the previous answer by the value of the house and round it off to 2 decimal points
elif type_of_calculator == ("investment"):
    type_of_interest = input("What type of interest would you like? (simple or compound) ")
# If the type of calculation is investment then ask the user to input the type of interest they would like to calculate their investment with
    if type_of_interest == ("simple"):
            interest_simple = float(input("What is the interest rate, without the % sign? "))
            deposit_simple = float(input("How much money are you going to deposit? R"))
            time_simple = int(input("How many years do you plan on investing? "))
            interest_simple = interest_simple/100
            total_simple = deposit_simple * (1 + interest_simple * time_simple)
            print("The amount you  will get after " + str(time_simple) + " years at the simple interest rate of " + str(interest_simple) + " is R" + str(total_simple))
# If the type of interest is simple the ask the user to input the interest rate, how much are they depositting, how much time they are investing for
# The calculations start with dividing the interest rate by 100
# Then multiplying the new value for the interest rate by by the value for the time being investted for and then adding 1 and multiplying this answer by the deposit amount
    else:
            interest_compound = float(input("What is the interest rate, without the % sign? "))
            deposit_compound = float(input("How much money are you planning to deposit? R"))
            time_compound = int(input("How many years do you plan on investing? "))
            interest_compound = interest_compound/100
            total_compound = round(deposit_compound * math.pow((1 + interest_compound), time_compound), 2)
            print("The amount you will get after " + str(time_compound) + " months at the compund interest rate of " + str(interest_compound) + " is R" + str(total_compound))
# if the user choose compound, then it asks the user the interest rate, deposit amount, the number of years they would like to invest
# Starts off our calculations by dividing our interest rate by 100
# Then add 1 to the interest rate and raise it to the power of the number of years and round it off by 2
