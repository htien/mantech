<%@ include file="layout/header.inc" %>
<compress:html
	jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">
	<h1>${welcomeMsg}</h1>
	<script type="text/javascript">
		// Copyright 2009 Google Inc. All Rights Reserved.

		/**
		 * Creates the DOM structure for the note and adds it to the document.
		 */
		function makeNoteDom(noteTitle, noteContent, noteContainer) {
			// Create DOM structure to represent the note.
			var headerElement = document.createElement('div');
			var headerText = document.createTextNode(noteTitle);
			headerElement.appendChild(headerText);
  
			var contentElement = document.createElement('div');
			var contentText = document.createTextNode(noteContent);
			contentElement.appendChild(contentText);

			var newNote = document.createElement('div');
			newNote.appendChild(headerElement);
			newNote.appendChild(contentElement);

			// Add the note's DOM structure to the document.
			noteContainer.appendChild(newNote);
		}

		/**
		 * Iterates over a list of note data objects and creates a DOM
		 */
		function makeNotes(data, noteContainer) {
			for (var i = 0; i < data.length; i++) {
				makeNoteDom(data[i].title, data[i].content, noteContainer);
			}
		}

		function main() {
			var noteData = [
				{title: 'Note 1', content: 'Content of Note 1'},
				{title: 'Note 2', content: 'Content of Note 2'}];
			var noteListElement = document.getElementById('notes');
			makeNotes(noteData, noteListElement);
		}

		main();

	</script>
</compress:html>
<%@ include file="layout/footer.inc" %>