SHELL := /usr/bin/sh

clean:
	@echo "Eliminando archivos autogenerados"
	@rm -f logs/*
	@rm -f src/main/resources/generatedFiles/*