# Defining the function re_user, which taskes in 3 variables
# While the x variable is not in the variable f_list, which will be defined later on, if y is equal to z then the output, which is the writing to the text file of x and z on a new line
# if the 'if' statement is not true then it should print the string
def reg_user(x, y, z):
    if x not in f_list and y == z:
        output = f.write(x + ", " + z + "\n")
    else:
        print("Username already exists, please try again")
        return

# Defining the function add_task, which takes in 5 variables
# The output variable, which is writing to the text file the joining of the variables which are being taken; with each variable seperated by commas and written on a new line.
# The function should return the variable output
def add_task(a, b, c, d, e, f):
    output = g.write(a + ", " + b + ", " + c + ", " + d + ", " + e + "\n")
    return output

# Defining the function view_all, which takes in no variables
# The variable contents which is supposed to read the text file g
def view_all():
    content = g.read()
    return

# Defining the function view_mine, which takes in no variables
# The variable content which is suppposed to read the text file g
# The for loop iterates over every line and creates a list, if the username is in that list then use a for loop to print out the number and print out the corresponding task as you go down the list
def view_mine():
    content = g.read()
    for line in content:
        g_list = content.split(",")
        if username in g_list:
            for i in range(1, len(g_list) - 5):
               print(str(i) + ". " + g_list[i + 1])
               return
    
# The importing the datetime from date is that we can get today's date
from datetime import date
# The today variable is to store today's date
# The d1  variable is to store today's date in the format we want in order to be able to compare dates later on
today = date.today()
d1 = today.strftime("%d %m %Y")
# Create and open the file user.txt as 'f' while being able to read and write
# Create and open the fiie tasks.txt as 'g' while being able to read and write
# Create and open the file task_overview.txt as 'h' while being able to read
# Create and open the file user_overview.txt as 'j' while being able to read
f = open("user.txt", "r+")
g = open("tasks.txt", "r+")
h = open("task_overview.txt", "w")
j = open("user_overview.txt", "w")

# Asks the user to input the username
# Asks the user to input the password
username = input("Please enter your username: ")
password = input("Please enter your password: ")

# Using the while loop, while the username and the password is not in the list ask the user to input the username and password again
# Else, if the password is in the users text file, then ask the user to input an option
# Print each one of the options and the input the selection in the menu variable
for line in f:
    f_list = line.split(",")
    if username not in f_list and password not in f_list:
        print("The username or password is incorrect. Please try again")
        username = input("Please enter your username: ")
        password = input("Please enter your password: ")
        
    else:
        print("Please select one of the following options:")
        print("r - register user")
        print("a - add task")
        print("va - view all tasks")
        print("vm - view my tasks")
        print("s - statistics")
        print("dr - display reports")
        print("e - exit")
menu = input(": ")

# if the the input of the menu is r and the user name is admin then ask the user for a new username, password and to confirm the password
# If both inputted passwords match then it should write to the user.txt file
if menu == "r" and username == "admin":
    new_username = input("Please enter a new username: ")
    new_password = input("Please enter a new password: ")
    confirm_password = input("Please confirm the password: ")
    
    reg_user(new_username, new_password, confirm_password)
    
# Else if, the user picked to add a task, then ask them to assign a username, the title of the task, description of the task, the due date of the task      
elif menu == "a":
    assign_username = input("Please enter the username of the person the task is being assigned to: ")
    title_task = input("Please enter the title of the task: ")
    description = input("Please describe the task: ")
    due_date = input("Please enter the due date of the task: ")
    complete = "No"
    
    add_task(assign_username, title_task, description, d1, due_date, complete)
    
# If the user chooses view all the tasks then it should read the file and print out what was read
elif menu == "va":
    print(view_all())
    
# If the users chooses 'view my tasks', then read the file, then iterate over every line, create a list with a every line in the variable g_list, if the username is in g_list then it should print out the line 
# Ask the user to choose a specific task or go back to the main menu by choosing '-1'
# If the user chooses a specific task them print out the options and ask the user for an input which will be saved in the variable option_1
elif menu == "vm":
    print(view_mine())
    task = int(input("Please choose a specific task or type '-1' to go back to the main menu"))
    while task == -1:
        continue
    else:
            print("Please choose one of the following options:")
            print("1 - Do you want to mark a task as complete?")
            print("2 - Do you want to edit the task?")
            option_1 = input(": ")
# Read the contents of the file
# Start the counter i at 0
# For every line of the text file you must split it into a list
# Then the if statement is checking whether the username is in the list
# If username is in the list
# if the username is in the list then add 1 to the counter, i
    content = g.read() 
    i = 0
    for line in content:
        g_list = content.split(",")
        if username in g_list:
            i += 1
# While the counter is equal to the input, task. if the user chooses 1 from the menu then replace the last element in the list
# Else if the user chooses 2 and the last element in the list is 'No' then the task should be edited by replaced by the inputted string.
# Else it should print an error
    while i == task:
        if option_1 == "1":
            g_list.replace(g_list[-1], "Yes")
        elif option_1 == "2" and g_list[-1] == "No":
            task_edit = input("Please edit the current task: ")
            g_list.replace(g_list[2], task_edit)
        else:
            print("Error! You can't edit a task which has been completed")
        
# if the user chooses statistics  then read the file, then split the file by each line and counter the number of the lines so that they count the number of users
elif menu == "s":
    c = 0
    for line in f:
        c += 1
print("The number of users is " + str(c))

# Then start the counter to count the number of tasks by creating a list and getting the length of the list and decreasing the number by four reducing it because of the elements lieted like username, due date, completion date and whether is been completed 
n = 0
for line in g:
        g_list = line.split(",")
        length = len(g_list)
        n = n + length
        n = n - 5
print("The number of tasks is: " + str(n))

# If the user chooses the display reports, the variable content should read the contents of the text file
# Initialise the counter n
# For every line in the text file, use the split funcion to create a list then calculate the length of the list
# Add the length to the variable n
# subtract 5 to remove all the other elements in the counting of elements except the task
# After the iteration, write the string to the text file saved as h
if menu == "dr":
    n = 0
    for line in g:
        g_list = line.split(",")
        length = len(g_list)
        n = n + length
        n = n - 5
h.write("The number of tasks that have been generated and tracked is " + str(n))

#Initialise the counter
# For every line in the text file, use the split function to create a list of the line
# If the last element in the list is 'Yes' add 1 to the counter to count the number of completed tasks
# After the iteration, write the string to the text file saved as h
ct = 0
for line in g:
    g_list = line.split(",")
    if g_list[-1] == "Yes":
        ct += 1
h.write("The total number of completed tasks is " + str(ct))

#Initialise the counter
# For every line in the text file, use the split function to create a list of the line
# If the last element in the list is 'Yes' add 1 to the counter to count the number of uncompleted tasks
# After the iteration, write the string to the text file saved as h
ut = 0
for line in g:
    g_list = line.split(",")
    if g_list[-1] == "No":
        ut += 1
h.write("The total number of uncompleted tasks is " + str(ut))

# For every line in the text file
# Using the split function to create a list
# Then initialising d2 variable to convert the string into a date with the format matching d1
# if the last element in g_list is 'No' and the due date has passed by comparing today's date and the due date
# After the iteration, write the string to the text file saved as h
c_o = 0
for line in g:
    g_list = line.split(",")
    d2 = datetime.strptime(g_list[-2],"%d %b %Y")
    if g_list[-1] == "No" and d1 > d2:
        c_o += 1
h.write("The total number of tasks that are uncomplete and overdue is " + str(c_o))

# Calculate the percentage of tasks that are incomplete by dividing the number of uncomplted tasks by the total number of tasks
# Write the string to the text file saved as h
pi = round((ut/n) * 100, 1)
h.write("The percentage of tasks that are incomplete is " + str(pi))

# Initialise the counter 'po'
# For every line in the text file saved g
# Use the split function to create a list by spliting it by a comma
# For the variable d2, convert the string into a date with the 'day (abbriviation)month years'
# Compare today's date with the due and if the due date has passed then add 1 to the counter
# In the variable p, calculate the percentage by dividing the number of overdue tasks by the total number of tasks multiplied 100. Then rounded off by 1
# Then write the string to the text file saved as h
po = 0
for line in g:
    g_list = line.split(",")
    d2 = datetime.strptime(g_list[-2], "%d %b %Y")
    if d1 > d2:
        po += 1
p = round((po/n) * 100, 1)
h.write("The percentage of tasks that are overdue is " + str(p))

# Initialise the counter
# For every line in the text file saved as f add 1 to the counter
# Write the string to the text file saved as j
ru = 0
for line in f:
    ru += 1
j.write("The total number of registered users is " + str(ru))

# Initialise the counter
# For every line in the text file saved as g
# Create a list seperated by a comma
# The variable length contains the length of g_list
# Then add the length to  the counter
# Then subtract 5 to only account for the number of tasks
# Then write the string to the text file saved as j
nt = 0 
for line in g:
    g_list = content.split(",")
    length = len(g_list)
    nt = nt + length
    nt = nt - 5
j.write("The total number of tasks that have been generated and tracked is " + str(nt))

# Initialise the counter
# For every line in the text file saved as g
# Create a list seperated by commas
# Then calculate the length of the list  in the variable length
# Then add the length of the to the counter tau
# Then subtract 5 to account the only fo the number of tasks
# write the string to text file saved as j
tau = 0
for line in g:
    g_list = line.split(",")
    if username in g_list:
        length = len(g_list)
        tau += length
        tau -= 5
j.write("The total number of tasks assigned to " + username + " is " + str(tau))

# Calculate the percentage by dividing the total number of task assigned to the user by the total number of tasks multiplied by 100 and rounded off to 1 decimal point in the variable pta
# Write the string to the text file saved as j
pta = round((tau/n) * 100, 1)
j.write("The percentage of the total number of tasks which have been assigned to " + username + " is " + str(pta))

# Initialise the counter
# For every line in the text file saved as g
# Use the split function too create a list seperated by a comma
# If the username is in g_list and the last element is Yes
# Then add 1 to the counter
# Then calculate the percentage by dividing the counter by the total number of tasks, then multiply by 100 and rounding it off to 1 decimal point
# Then write the string to the file saved as j
tc = 0
for line in g:
    g_list = line.split(",")
    if username in g_list and g_list[-1] == "Yes":
        tc += 1
ptc = round((tc/n) * 100, 1)
j.write("The percentage of the total number of tasks which have been assigned to " + username + " which has been completed is " + str(ptc))

# Initialise the counter
# for eevery line in the text file saved as g
# Use the split function to create a list
# If the username is in the list and the last element in the list is No then add 1 to the counter
# To calculate the percentage of not completed tasks for the username by dividing the counter by the total number of tasks, then multiply by 100 and rounding it off to 1 decimal point
#  Then write it to the text file saved as j
tu = 0
for line in g:
    g_list = line.split(",")
    if username in g_list and g_list[-1] == "No":
        tu += 1
ptu = round((tu/n) * 100, 1)
j.write("The percentage of the total number of tasks which have been assigned to " + username + " which has no been completed is " + str(ptu))

# Initialise the counter
# For every line in the text file saved as g
# d2 variable converts the string into a date
# If the last element is No and the due date has passed
# Add 1 to the counter
# Then calvulate the percentage by dividing the counter by the total number of tasks, multiply by 100 and rounding to 1 decimal point
# Write the string to the text file saved as j
tcu = 0
for line in g:
    g_list = line.split(",")
    if username in g_list:
        d2 = datetime.strptime(g_list[-2], "%d %b %Y")
        if g_list[-1] == "No" and d1 > d2:
            tcu += 1
ptcu = round((tcu/n) * 100, 1)
j.write("The percentage of the tasks assigned to " + username + " that has been not been completed and are overdue is " + str(ptcu))
        
# Then close all files    
f.close()
g.close()
h.close()
j.close()
    
    



    
