# Import game that allows us to use certain functions.
# Import random to allow us to generate random numbers
import pygame
import random
# Initializesz the modules
pygame.init()
# Create the dimensions of the screen
screen_width = 780
screen_height = 340
screen = pygame.display.set_mode((screen_width,screen_height))
# Creates the player, the enemies and the prize. As well as gives them all images
player = pygame.image.load("Player.png")
enemy1 = pygame.image.load("enemy1.png")
enemy2 = pygame.image.load("enemy2.png")
enemy3 = pygame.image.load("enemy3.png")
enemy4 = pygame.image.load("enemy3.png")
enemy5 = pygame.image.load("enemy2.png")
prize1 = pygame.image.load("Prize1.jpg")
# Gets the width and the height of the images for boundary detection
player_height = player.get_height()
player_width = player.get_width()
enemy1_height = enemy1.get_height()
enemy1_width = enemy1.get_width()
enemy2_height = enemy2.get_height()
enemy2_width = enemy2.get_width()
enemy3_height = enemy3.get_height()
enemy3_width = enemy3.get_width()
enemy4_height = enemy4.get_height()
enemy4_width = enemy4.get_width()
enemy5_height = enemy5.get_height()
enemy5_width = enemy5.get_width()
prize1_height = prize1.get_height()
prize1_width = prize1.get_width()
# Store the start points of the player, enemies and the prize
playerXPosition = 260
playerYPosition = 250
enemy1XPosition = 0
enemy1YPosition = random.randint(0, screen_height - enemy1_height)
enemy2XPosition = screen_width
enemy2YPosition = random.randint(0, screen_height - enemy2_height)
enemy3XPosition = 0
enemy3YPosition = random.randint(0, screen_height - enemy3_height)
enemy4XPosition = screen_width
enemy4YPosition = random.randint(0, screen_height - enemy4_height)
enemy5XPosition = 0
enemy5YPosition = random.randint(0, screen_height - enemy5_height)
prize1XPosition = random.randint(0, screen_width - prize1_width)
prize1YPosition = random.randint(0, screen_height - prize1_height)
# This will check if the up, down, left or right key is pressed
# Because they are currently not pressed they are all false
keyUp = False
keyDown = False
keyLeft = False
keyRight = False
# While 1, means that while all is true. It should run this code
while 1:
# Clears the screen
# This puts the images of the player, enemies and the prize on the screen on their specified positions
    screen.fill(0)
    screen.blit(player, (playerXPosition, playerYPosition))
    screen.blit(enemy1, (enemy1XPosition, enemy1YPosition))
    screen.blit(enemy2, (enemy2XPosition, enemy2YPosition))
    screen.blit(enemy3, (enemy3XPosition, enemy3YPosition))
    screen.blit(enemy4, (enemy4XPosition, enemy4YPosition))
    screen.blit(enemy5, (enemy5XPosition, enemy4YPosition))
    screen.blit(prize1, (prize1XPosition, prize1YPosition))
# Updates the screen
    pygame.display.flip()
# This checks if the user has still not quit the program
    for event in pygame.event.get():
    
        if event.type == pygame.QUIT:
            pygame.quit()
            exit(0)
# This checks if any key has been pressed down
        if event.type == pygame.KEYDOWN:
# Checks which key is pressed down and if its the one we want
            if event.key == pygame.K_LEFT:
                keyLeft = True
            if event.key == pygame.K_RIGHT:
                keyRight = True
            if event.key == pygame.K_UP:
                keyUp = True
            if event.key == pygame.K_DOWN:
                keyDown = True
# This checks if the key is not pressed down
        if event.type == pygame.KEYUP:
# Checks which of the keys are not pressed and if its the one we want
            if event.key == pygame.K_LEFT:
                keyLeft = False
            if event.key == pygame.K_RIGHT:
                keyRight = False
            if event.key == pygame.K_UP:
                keyUp = False
            if event.key == pygame.K_DOWN:
                keyDown = False
# This makes sure that the user doesn't move out of the window
    if keyLeft == True:
         if playerXPosition > 0:
             playerXPosition -= 1
    if keyRight == True:
         if playerXPosition < screen_width - player_width:
             playerXPosition += 1
    if keyUp == True:
         if playerYPosition > 0:
             playerYPosition -= 1
    if keyDown == True:
         if playerYPosition < screen_height - player_height:
             playerYPosition += 1
# Checks for the collision of the player and the enemies  and the player and the prize
# To make this happen, we must have bounding boxes around all the characters

# Boundin box for player
    playerBox = pygame.Rect(player.get_rect())
    playerBox.top  = playerYPosition
    playerBox.left = playerXPosition
# Bounding boxes for the enemies
    enemy1Box = pygame.Rect(enemy1.get_rect())
    enemy1Box.top = enemy1YPosition
    enemy1Box.left = enemy1XPosition

    enemy2Box = pygame.Rect(enemy2.get_rect())
    enemy2Box.top = enemy2YPosition
    enemy2Box.left = enemy2XPosition

    enemy3Box = pygame.Rect(enemy3.get_rect())
    enemy3Box.top = enemy3YPosition
    enemy3Box.left = enemy3XPosition

    enemy4Box = pygame.Rect(enemy4.get_rect())
    enemy4Box.top = enemy4YPosition
    enemy4Box.left = enemy4XPosition

    enemy5Box = pygame.Rect(enemy5.get_rect())
    enemy5Box.top = enemy5YPosition
    enemy5Box.left = enemy5XPosition
# Bounding box for the prize
    prize1Box = pygame.Rect(enemy3.get_rect())
    prize1Box.top = prize1YPosition
    prize1Box.left = prize1XPosition
# Testing for the collision of the boxes
# printing a tring if the collision is true
# Then quits and exits the game
    if playerBox.colliderect(enemy1Box):
        print("You lose!")
        pygame.quit()
        exit(0)

    if playerBox.colliderect(enemy2Box):
        print("You lose!")
        pygame.quit()
        exit(0)

    if playerBox.colliderect(enemy3Box):
        print("You lose!")
        pygame.quit()
        exit(0)
    if playerBox.colliderect(enemy4Box):
        print("You lose!")
        pygame.quit()
        exit(0)
    if playerBox.colliderect(enemy5Box):
        print("You lose!")
        pygame.quit()
        exit(0)

    if playerBox.colliderect(prize1Box):
        print("You win!")
        print("Score: 100")
        pygame.quit()
        exit(0)

    if (enemy1XPosition < 0 - enemy1_width) and (enemy2XPosition < 0 - enemy2_width) and (enemy3XPosition < 0 - enemy3_width) and (enemy4XPosition < 0 - enemy4_width) and (enemy5XPosition < 0 - enemy5_width):
        print("You win!")
        pygame.quit()
        exit(0)
# Make the enemy move on the screen in different speeds
    enemy1XPosition += 0.35
    enemy2XPosition -= 0.15
    enemy3XPosition += 0.25
    enemy4XPosition -= 0.45
    enemy5XPosition += 0.55    
