@testAPI
Feature: Update user Feature

Scenario: Test update user functionality

Given I update user using <"user2.json">
Then I validate details as updated