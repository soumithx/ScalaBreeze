GitRefresh()
{
git add *
git commit -m "Update Readme"
git push
}

while true
do
	GitRefresh
done

