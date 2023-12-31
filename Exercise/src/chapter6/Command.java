/*******************************************************************************
 * Companion code for the book "Introduction to Software Design with Java" 
 * by Martin P. Robillard.
 *
 * Copyright (C) 2019 by Martin P. Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 *
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/
package chapter6;

import java.util.Optional;

import chapter4.Card;

/**
 * Represents an abstract command in the Command design pattern.
 */
public interface Command {
  Optional<Card> execute();

  void undo();
}
