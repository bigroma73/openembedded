#!/usr/bin/env python
import sys, os, string, getopt, re

mtncmd = "mtn"

def main(argv = None):
    if argv is None:
        argv = sys.argv
    opts, list = getopt.getopt(sys.argv[1:], ':R')
    if len(list) < 1:
        print "You must specify a file"
        return 2
    reverse = False
    for o, a in opts:
        if o == "-R":
            reverse = True
    if os.path.exists(list[0]):
        input = open(list[0], 'r')
        renameFrom = ""
        cmd = ""
        for line in input:
            if len(line) > 0:
                if line[0] == '#':
                    matches = re.search("#\s+(\w+)\s+\"(.*)\"", line)
                    if matches is not None:
                        cmd = matches.group(1)
                        fileName = matches.group(2)
                        if cmd == "delete":
                            if reverse:
                                print "%s add %s" % (mtncmd, fileName)
                            else:
                                print "%s drop -e %s" % (mtncmd, fileName)
                        elif cmd == "add" or cmd == "add_file" or cmd == "add_dir":
                            if reverse:
                                print "%s drop -e %s" % (mtncmd, fileName)
                            else:
                                print "%s add %s" % (mtncmd, fileName)
                        elif cmd == "rename":
                            renameFrom = fileName
                        elif cmd == "to" and renameFrom != "":
                            if reverse:
                                print "%s rename -e %s %s" % (mtncmd, fileName, renameFrom)
                            else:
                                print "%s rename -e %s %s" % (mtncmd, renameFrom, fileName)
                            renameFrom = ""
                        else:
                            cmd = ""
        if reverse:
            print "patch -R -p0 < %s" % list[0]
        else:
            print "patch -p0 < %s" % list[0]

if __name__ == "__main__":
    sys.exit(main())
