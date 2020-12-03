# Example starting point for developing a Flexy app 

## Starting a project with this repository 
To adding the --recursive parameter to the git clone command will initialize all submodules.
```Shell Session
git clone git@github.com:it-hms/flexy-starting-point.git --recursive
```
It's also possible to initialize modules after they have been initialized
```Shell Session
$ git submodule update --init 
```

## change remote 
Because this project is designed to jump start other projects, create a new repo in github, then change the origin with the following command
```Shell Session
$ git remote set-url origin https://github.com/USERNAME/REPOSITORY.git
```

## Ant build file template
Rename build_template.xml to build.xml
## IDEA project import 
After cloning and initializing submodules, import project into IDEA as a project folder. Then, designate src folders.