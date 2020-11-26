# Donation Code Challenge

Hey there! Welcome to the COYO backend challenge. Don't be afraid, the main focus is not about failing or succeeding in the given tasks, but to have chat about code, codestyle and architectural things. So let's go.

## The project

This project was born for the Covid-19 Hackathon https://wirvsvirus.org/ back in march 2020. The source code here reflects an early state, fastly boostrapped on a friday evening. You will probably find a number of 'dodgy' things ;)

### Business case 

The idea behind the project is to help small local shops or restaurant through the pandemic situation by donations.
A 'user' can pick a location on a Google Map and donate a certain amount of money. 
The owner (entrepreneur) of e.g. the restaurant will receive a letter (currently just a catch all mail) with an invitation code. 
By using that code the entrepreneur can see his current contact information and set them ones, but most importantly he or she can check the donation balance.

## The process

1. A user requests a nonce for the payment provider.
2. The user makes a donation request and donates money to several places.
3. A mail is sent to those places with an invitation code.
4. Using that code a) The owner can set his contact information
   b) The owner can check his balance

## Good to know
- There is a mailhog running on port 8025 where you can see all mails that are send.
- There is a postman collection in the root directory with all requests that you can use.
- The payment provider is mocked out. You do not need a valid one.

## Requirements

- Java 13 (sdkman is a nice helper if you have another version installed)
- Docker and Docker-Compose
- Your IDE of preference

## How to start

- Spin up the compose-file
- Start the ServiceApplication. Do not forget to set spring.profiles.active=dev

## Tasks

- Have a look through the code.