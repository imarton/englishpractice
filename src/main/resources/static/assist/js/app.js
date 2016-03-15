/**
 * 
 */
(function () {
    'use strict';

    var DEBUG = true;
    
	 // Returns a random integer between min (included) and max (excluded)
	 // Using Math.round() will give you a non-uniform distribution!
    function getRandomInt(min, max) {
    	return Math.floor(Math.random() * (max - min)) + min;
	}
    
    //--------------------------------------------------------------------
    
    var questionList = [
    	{ //minta adat
    		id: 0,
    		hungarian: 'Szia',
    		english: 'Hi'
    	}
    ];
    
    var answerList = [
	 	{ //minta adat
	 		questionId: 0,
	 		success: true
	 	}
	];
    
    var app = angular.module('practiceApp3', [
       // Angular modules
        'ngAnimate',
        'ngRoute'

        // Custom modules

        // 3rd Party Modules 
    ]);
    
    /**
     * Megviszgálja hogy a paraméterként átadott két szövegrész hasonló-e.
     * Azaz a szóközöktől eltekintve egyezik-e
     */
    function isSimilar(text1, text2) {    	
    	
    	if(text1 === text2) return true;		
		if (text1 == null || text2 == null) return false;
		
		
    	// fölösleges szóközök eltávolítása és kisbetűssé alakítása
		text1 = text1.trim().toLowerCase();
		text2 = text2.trim().toLowerCase();
		
		if (text1 == '' || text2 == '') return false;
		
			
		var ot = text1.split(' ');
		var at = text2.split(' ');
		
		if(at.length !=  ot.length) return false;
		
		for (var i = 0; i < ot.length; i++) {
			if(ot[i] != at[i]) return false;
		}
		
    	return true;
    }
    
    app.controller('practiceController', function($scope) {
    	$scope.qlist = questionList;
    	$scope.aList = answerList;
    	$scope.qIndex = -1;
    	$scope.message = '';
    	$scope.isCorrect = null;
    	
    	/**
    	 * Megjeleníti a következő kérdést
    	 */
    	$scope.nextQuestion = function() {
    		var langs = ['hu', 'eng']; 
    		$scope.langBase =  langs[getRandomInt(0,2)];
    		if (DEBUG)  console.log('Nyelv: ' +$scope.langBase);
    		
    		$scope.qIndex++;
    		$scope.hungarian = '';
    		$scope.english = '';
    		$scope.message = '';
    		$scope.isCorrect = null;
    		
    		if ($scope.langBase == 'hu') 
    			$scope.hungarian = $scope.qlist[$scope.qIndex].hungarian;
    		else 
    			$scope.english = $scope.qlist[$scope.qIndex].english;
    		
    	}
    	
    	/**
    	 * Ellenőrzi a kérdésre adott választ
    	 */
    	$scope.checkAnswer = function() {    		
    		var original, answer;
    		if($scope.langBase == 'hu') {
    			original = $scope.qlist[$scope.qIndex].english;
    			answer = $scope.english;
    		}
    		else {
    			original = $scope.qlist[$scope.qIndex].hungarian;
    			answer = $scope.hungarian;
    		}
    		
    		if (DEBUG)  console.log("Ellenőrzés: eredeti: '" +original + "'  adott válasz:'" + answer +"'");
    		
    		$scope.isCorrect = isSimilar(original, answer);
    		if ($scope.isCorrect) 
    			$scope.message = 'Helyes!';
    		else {
    			$scope.message = 'Sajnos nem jó!';
    		}
    	}
    	
    	/**
    	 * Megmutatja a helyes választ
    	 */
    	$scope.showRightAnswer = function() {
    		if ($scope.langBase == 'hu') 
    			$scope.message = 'A helyes válasz: ' + $scope.qlist[$scope.qIndex].english;
    		else 
    			$scope.message = 'A helyes válasz: ' + $scope.qlist[$scope.qIndex].hungarian;
    	}
    
    });    
    
    
}
)();