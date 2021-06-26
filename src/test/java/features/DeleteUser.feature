@testAPI
Feature: Delete user Feature

Scenario: Test delete user functionality

Given I hit user creation request using <"user.json">
Then I capture user ID
Then I delete the created user